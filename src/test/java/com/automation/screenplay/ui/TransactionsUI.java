package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransactionsUI {
    public static final Target BUTTON_OPEN_MODAL = Target.the("open transaction modal button")
            .located(By.xpath("//button[contains(.,'Transacci') or .//*[contains(@class, 'lucide-plus')]]"));
    
    public static final Target INPUT_DESCRIPTION = Target.the("description input").located(By.name("description"));
    public static final Target INPUT_AMOUNT = Target.the("amount input").located(By.name("amount"));
    public static final Target INPUT_DATE = Target.the("date input").located(By.name("date"));
    public static final Target BUTTON_SUBMIT = Target.the("submit transaction button")
            .located(By.xpath("//button[@type='submit' and contains(., 'Crear')]"));
    
    public static final Target TABLE_ROWS = Target.the("transaction table rows").located(By.cssSelector("table tbody tr"));

    // Custom selects (dynamic)
    public static Target selectByLabel(String label) {
        return Target.the("select for " + label)
                .located(By.xpath("//label[contains(.,'" + label + "')]/following-sibling::button | //label[contains(.,'" + label + "')]/..//button"));
    }

    public static Target optionWithText(String text) {
        return Target.the("option " + text)
                .located(By.xpath("//div[@role='option' or @role='menuitem' or @role='listbox']//*[contains(text(), '" + text + "')] | //div[@role='option' or @role='menuitem' or @role='listbox'][contains(., '" + text + "')]"));
    }
}
