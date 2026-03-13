package com.automation.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SetDateViaJs implements Task {

    private final Target target;
    private final String date;

    public SetDateViaJs(Target target, String date) {
        this.target = target;
        this.date = date;
    }

    public static SetDateViaJs on(Target target, String date) {
        return instrumented(SetDateViaJs.class, target, date);
    }

    @Override
    @Step("{0} sets date '#date' on #target via JavaScript")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Evaluate.javascript(
                        "arguments[0].value = arguments[1]; " +
                        "arguments[0].dispatchEvent(new Event('input',  {bubbles: true})); " +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
                        target.resolveFor(actor),
                        date
                )
        );
    }
}
