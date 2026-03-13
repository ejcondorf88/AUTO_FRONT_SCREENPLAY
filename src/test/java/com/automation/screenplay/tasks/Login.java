package com.automation.screenplay.tasks;

import com.automation.screenplay.ui.DashboardUI;
import com.automation.screenplay.ui.LoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Fills in credentials and submits the login form.
 * Pre-condition: actor must already be on the login page.
 * Navigation is the caller's responsibility (use Navigate task).
 */
public class Login implements Task {

    private final String email;
    private final String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Login withCredentials(String email, String password) {
        return instrumented(Login.class, email, password);
    }

    @Override
    @Step("{0} logs in with email #email and password #password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginUI.INPUT_EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(LoginUI.INPUT_EMAIL),
                Enter.theValue(password).into(LoginUI.INPUT_PASSWORD),
                Click.on(LoginUI.BUTTON_LOGIN),
                WaitUntil.the(DashboardUI.AVATAR_USER, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
