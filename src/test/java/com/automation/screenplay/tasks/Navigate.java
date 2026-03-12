package com.automation.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {

    private final String url;

    public Navigate(String url) {
        this.url = url;
    }

    public static Navigate to(String url) {
        return instrumented(Navigate.class, url);
    }

    @Override
    @Step("{0} navigates to #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}
