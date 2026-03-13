package com.automation.screenplay.tasks;

import com.automation.screenplay.actions.SetDateViaJs;
import com.automation.screenplay.ui.TransactionsUI;
import com.automation.utils.TransactionType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
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
    private final String category;

    public AddTransaction(String type, String description, String amount, String date, String category) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    /** Factory method with default category "Otros". */
    public static AddTransaction withData(String type, String description, String amount, String date) {
        return instrumented(AddTransaction.class, type, description, amount, date, "Otros");
    }

    /** Factory method when a specific category is needed. */
    public static AddTransaction withData(String type, String description, String amount, String date, String category) {
        return instrumented(AddTransaction.class, type, description, amount, date, category);
    }

    @Override
    @Step("{0} adds a #type transaction: #description (#amount) on #date")
    public <T extends Actor> void performAs(T actor) {
        String tipoTexto = TransactionType.toUiLabel(type);

        actor.attemptsTo(
                WaitUntil.the(TransactionsUI.BUTTON_OPEN_MODAL, isClickable()),
                Click.on(TransactionsUI.BUTTON_OPEN_MODAL),

                WaitUntil.the(TransactionsUI.SELECT_TIPO, isClickable()),
                Click.on(TransactionsUI.SELECT_TIPO),
                WaitUntil.the(TransactionsUI.optionWithText(tipoTexto), isVisible()),
                Click.on(TransactionsUI.optionWithText(tipoTexto)),

                WaitUntil.the(TransactionsUI.SELECT_CATEGORIA, isClickable()),
                Click.on(TransactionsUI.SELECT_CATEGORIA),
                WaitUntil.the(TransactionsUI.optionWithText(category), isVisible()),
                Click.on(TransactionsUI.optionWithText(category)),

                Enter.theValue(description).into(TransactionsUI.INPUT_DESCRIPTION),
                Enter.theValue(amount).into(TransactionsUI.INPUT_AMOUNT),

                SetDateViaJs.on(TransactionsUI.INPUT_DATE, date),

                Click.on(TransactionsUI.BUTTON_SUBMIT),
                WaitUntil.the(TransactionsUI.BUTTON_SUBMIT, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}
