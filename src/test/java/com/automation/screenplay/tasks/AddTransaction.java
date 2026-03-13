package com.automation.screenplay.tasks;

import com.automation.screenplay.ui.TransactionsUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddTransaction implements Task {

    private final String type;
    private final String description;
    private final String amount;
    private final String date;

    public AddTransaction(String type, String description, String amount, String date) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public static AddTransaction withData(String type, String description, String amount, String date) {
        return instrumented(AddTransaction.class, type, description, amount, date);
    }

    @Override
    @Step("{0} adds a #type transaction: #description (#amount) on #date")
    public <T extends Actor> void performAs(T actor) {
        String tipoTexto = type.toLowerCase().contains("income") || type.toLowerCase().contains("ingreso")
            ? "Ingreso" : "Egreso";

        actor.attemptsTo(
                WaitUntil.the(TransactionsUI.BUTTON_OPEN_MODAL, isClickable()),
                Click.on(TransactionsUI.BUTTON_OPEN_MODAL),

                WaitUntil.the(TransactionsUI.SELECT_TIPO, isClickable()),
                Click.on(TransactionsUI.SELECT_TIPO),
                WaitUntil.the(TransactionsUI.optionWithText(tipoTexto), isVisible()),
                Click.on(TransactionsUI.optionWithText(tipoTexto)),

                WaitUntil.the(TransactionsUI.SELECT_CATEGORIA, isClickable()),
                Click.on(TransactionsUI.SELECT_CATEGORIA),
                WaitUntil.the(TransactionsUI.optionWithText("Otros"), isVisible()),
                Click.on(TransactionsUI.optionWithText("Otros")),

                Enter.theValue(description).into(TransactionsUI.INPUT_DESCRIPTION),
                Enter.theValue(amount).into(TransactionsUI.INPUT_AMOUNT),

                Evaluate.javascript(
                    "arguments[0].value = arguments[1]; " +
                    "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); " +
                    "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
                    TransactionsUI.INPUT_DATE.resolveFor(actor), date
                ),

                Click.on(TransactionsUI.BUTTON_SUBMIT),
                WaitUntil.the(TransactionsUI.BUTTON_SUBMIT, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}
