package org.hludov;

public enum Command {

    CURRENCY_RATES("currency_rates"),
    ;

    private final String value;
    private Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
