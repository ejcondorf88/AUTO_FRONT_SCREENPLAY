package com.automation.screenplay.tasks;

import com.automation.screenplay.ui.TransactionsUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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
        String searchText = type.toLowerCase().contains("income") || type.toLowerCase().contains("ingreso") ? "Ingreso" : "Egreso";

        actor.attemptsTo(
                Click.on(TransactionsUI.BUTTON_OPEN_MODAL),
                Click.on(TransactionsUI.selectByLabel("Tipo")),
                Click.on(TransactionsUI.optionWithText(searchText)),
                Click.on(TransactionsUI.selectByLabel("Categ")),
                Click.on(TransactionsUI.optionWithText("Otros")), // Defaulting to Otros for simplicity
                Enter.theValue(description).into(TransactionsUI.INPUT_DESCRIPTION),
                Enter.theValue(amount).into(TransactionsUI.INPUT_AMOUNT),
                // Since date input is tricky in some frameworks, we can use the same JS logic if needed, 
                // but for now we try Enter.
                Enter.theValue(date).into(TransactionsUI.INPUT_DATE),
                Click.on(TransactionsUI.BUTTON_SUBMIT)
        );
    }
}
