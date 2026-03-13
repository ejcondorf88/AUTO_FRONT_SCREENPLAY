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

    // Dropdown trigger button next to the label
    public static Target selectByLabel(String label) {
        return Target.the("select for " + label)
                .located(By.xpath(
                    "//label[normalize-space()='" + label + "']/following-sibling::*//button" +
                    " | //label[contains(normalize-space(),'" + label + "')]/..//button[@role='combobox']" +
                    " | //label[contains(normalize-space(),'" + label + "')]/following-sibling::button"
                ));
    }

    // Option inside an open dropdown/popover
    public static Target optionWithText(String text) {
        return Target.the("option " + text)
                .located(By.xpath(
                    "//*[@role='option'][normalize-space()='" + text + "']" +
                    " | //*[@role='option'][.//*[normalize-space()='" + text + "']]" +
                    " | //*[@role='menuitem'][normalize-space()='" + text + "']"
                ));
    }

    // Specific dropdown for "Tipo"
    public static final Target SELECT_TIPO = Target.the("tipo dropdown")
            .located(By.xpath("//label[contains(.,'Tipo')]/following-sibling::button | //label[contains(.,'Tipo')]/..//button[@role='combobox']"));

    // Specific dropdown for "Categoría"
    public static final Target SELECT_CATEGORIA = Target.the("categoria dropdown")
            .located(By.xpath("//label[contains(.,'Categ')]/following-sibling::button | //label[contains(.,'Categ')]/..//button[@role='combobox']"));
}
