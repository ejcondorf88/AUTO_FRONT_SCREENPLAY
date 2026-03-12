package com.automation.screenplay.questions;

import com.automation.screenplay.ui.DashboardUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class DashboardTitle implements Question<String> {

    public static DashboardTitle value() {
        return new DashboardTitle();
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return Text.of(DashboardUI.LABEL_DASHBOARD).answeredBy(actor);
    }
}
