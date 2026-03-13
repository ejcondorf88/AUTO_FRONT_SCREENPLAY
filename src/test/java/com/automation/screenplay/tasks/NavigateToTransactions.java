package com.automation.screenplay.tasks;

import com.automation.screenplay.ui.DashboardUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToTransactions implements Task {

    public static NavigateToTransactions module() {
        return instrumented(NavigateToTransactions.class);
    }

    @Override
    @Step("{0} navigates to transactions module via sidebar")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(WebElementQuestion.stateOf(DashboardUI.LINK_TRANSACTIONS), isVisible())
                     .otherwise(
                         WaitUntil.the(DashboardUI.BUTTON_SIDEBAR_TRIGGER, isClickable()),
                         Click.on(DashboardUI.BUTTON_SIDEBAR_TRIGGER)
                     ),
                WaitUntil.the(DashboardUI.LINK_TRANSACTIONS, isVisible()),
                JavaScriptClick.on(DashboardUI.LINK_TRANSACTIONS)
        );
    }
}
