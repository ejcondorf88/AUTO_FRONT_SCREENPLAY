package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static final Target INPUT_EMAIL = Target.the("email input").located(By.id("email"));
    public static final Target INPUT_PASSWORD = Target.the("password input").located(By.id("password"));
    public static final Target BUTTON_LOGIN = Target.the("login button").located(By.cssSelector("button[type='submit']"));
    public static final Target LINK_REGISTER = Target.the("register link").located(By.cssSelector("a[href='/register']"));
}
