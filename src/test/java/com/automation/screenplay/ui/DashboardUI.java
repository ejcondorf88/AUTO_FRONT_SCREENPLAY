package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardUI {
    public static final Target LABEL_DASHBOARD = Target.the("dashboard header label").locatedBy("[data-slot='breadcrumb-page']");
    public static final Target AVATAR_USER = Target.the("user avatar").locatedBy("[data-slot='avatar']");
    public static final Target BUTTON_SIDEBAR_TRIGGER = Target.the("sidebar trigger button").locatedBy("[data-slot='sidebar-trigger']");
    public static final Target LINK_TRANSACTIONS = Target.the("transactions link").located(By.xpath("//a[contains(@href,'transactions')]"));
}
