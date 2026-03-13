package com.automation.utils;

import java.util.Arrays;

public enum TransactionType {

    INCOME("Ingreso"),
    EXPENSE("Egreso");

    private final String uiLabel;

    TransactionType(String uiLabel) {
        this.uiLabel = uiLabel;
    }

    public String getUiLabel() {
        return uiLabel;
    }
    public static String toUiLabel(String raw) {
        return Arrays.stream(values())
                .filter(t -> t.name().equalsIgnoreCase(raw))
                .map(TransactionType::getUiLabel)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unknown transaction type: '" + raw +
                                "'. Expected: income | expense"));
    }
}
