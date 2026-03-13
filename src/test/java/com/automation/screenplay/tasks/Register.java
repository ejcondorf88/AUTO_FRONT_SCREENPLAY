package com.automation.screenplay.tasks;

import com.automation.screenplay.ui.LoginUI;
import com.automation.screenplay.ui.RegisterUI;
import com.automation.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
    @Step("{0} registers a new user starting from Login page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Navigate.to(Constants.LOGIN_URL),
                WaitUntil.the(LoginUI.LINK_REGISTER, isClickable()),
                Click.on(LoginUI.LINK_REGISTER),
                WaitUntil.the(RegisterUI.INPUT_DISPLAY_NAME, isClickable()),
                Enter.theValue(name).into(RegisterUI.INPUT_DISPLAY_NAME),
                Enter.theValue(email).into(RegisterUI.INPUT_EMAIL),
                Enter.theValue(password).into(RegisterUI.INPUT_PASSWORD),
                Enter.theValue(password).into(RegisterUI.INPUT_CONFIRM_PASSWORD),
                Click.on(RegisterUI.BUTTON_REGISTER),
                // Important: Wait for the app to process registration and redirect to Login
                WaitUntil.the(LoginUI.INPUT_EMAIL, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
