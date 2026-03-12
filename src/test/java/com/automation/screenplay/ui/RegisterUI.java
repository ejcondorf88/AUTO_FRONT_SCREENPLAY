package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterUI {
    public static final Target INPUT_DISPLAY_NAME = Target.the("display name input").located(By.id("displayName"));
    public static final Target INPUT_EMAIL = Target.the("email input").located(By.id("email"));
    public static final Target INPUT_PASSWORD = Target.the("password input").located(By.id("password"));
    public static final Target INPUT_CONFIRM_PASSWORD = Target.the("confirm password input").located(By.id("confirmPassword"));
    public static final Target BUTTON_REGISTER = Target.the("register button").located(By.cssSelector("button[type='submit']"));
}
