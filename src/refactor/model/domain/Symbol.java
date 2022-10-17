package refactor.model.domain;

public enum Symbol   {
    PLUS("+"),
    MINUS("-"),
    DIVISION("/"),
    MULTIPLICATION("*");

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
