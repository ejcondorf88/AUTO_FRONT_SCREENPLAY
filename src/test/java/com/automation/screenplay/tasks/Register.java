package com.automation.screenplay.tasks;

import com.automation.screenplay.ui.RegisterUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task {

    private final String name;
    private final String email;
    private final String password;

    public Register(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Register withData(String name, String email, String password) {
        return instrumented(Register.class, name, email, password);
    }

    @Override
    @Step("{0} registers a new user with name #name and email #email")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(com.automation.utils.Constants.REGISTER_URL),
                Enter.theValue(name).into(RegisterUI.INPUT_DISPLAY_NAME),
                Enter.theValue(email).into(RegisterUI.INPUT_EMAIL),
                Enter.theValue(password).into(RegisterUI.INPUT_PASSWORD),
                Enter.theValue(password).into(RegisterUI.INPUT_CONFIRM_PASSWORD),
                Click.on(RegisterUI.BUTTON_REGISTER)
        );
    }
}
