package com.automation.screenplay.questions;

import com.automation.screenplay.ui.TransactionsUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Collection;

/**
 * Reads text from a specific column of the transaction table.
 * Use the static factory methods to select the column of interest.
 */
public class TransactionList implements Question<Collection<String>> {

    private final Target column;

    private TransactionList(Target column) {
        this.column = column;
    }

    /** Returns the text of every cell in the Description column. */
    public static TransactionList descriptions() {
        return new TransactionList(TransactionsUI.COLUMN_DESCRIPTION);
    }

    /** Returns the text of every cell in the Amount column. */
    public static TransactionList amounts() {
        return new TransactionList(TransactionsUI.COLUMN_AMOUNT);
    }

    @Override
    public Collection<String> answeredBy(Actor actor) {
        Collection<String> texts = Text.ofEach(column).answeredBy(actor);
        if (column == TransactionsUI.COLUMN_AMOUNT) {
            return texts.stream()
                .map(text -> text.replace(".", "").replace("$", "").replace("+", "").replace("-", "").trim())
                .collect(java.util.stream.Collectors.toList());
        }
        return texts;
    }
}
