package com.automation.screenplay.questions;

import com.automation.screenplay.ui.TransactionsUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public class TransactionList implements Question<Collection<String>> {

    public static TransactionList descriptions() {
        return new TransactionList();
    }

    @Override
    public Collection<String> answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return Text.ofEach(TransactionsUI.TABLE_ROWS).answeredBy(actor);
    }
}
