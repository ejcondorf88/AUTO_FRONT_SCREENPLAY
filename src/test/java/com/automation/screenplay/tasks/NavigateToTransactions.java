package com.automation.screenplay.tasks;

import com.automation.screenplay.ui.DashboardUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToTransactions implements Task {

    public static NavigateToTransactions module() {
        return instrumented(NavigateToTransactions.class);
    }

    @Override
    @Step("{0} navigates to transactions module via sidebar")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardUI.BUTTON_SIDEBAR_TRIGGER),
                WaitUntil.the(DashboardUI.LINK_TRANSACTIONS, isVisible()),
                Click.on(DashboardUI.LINK_TRANSACTIONS)
        );
    }
}
