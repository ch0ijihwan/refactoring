package refactor.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionSplitter {

    private static final int FIRST_NUMBER_INDEX = 0;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_NUMBER_INDEX = 1;
    private static final String BLANK = " ";
    private static final String DELIMITER = "";

    private final List<Integer> operands;
    private final Symbol symbol;

    public ExpressionSplitter(final String expression) {
        String noneBlankExpression = removeBlanks(expression);
        symbol = findSymbol(noneBlankExpression);
        operands = findNumbers(noneBlankExpression, symbol);
    }

    private String removeBlanks(final String expression) {
        List<String> tokens = Arrays.stream(expression.split(DELIMITER))
                .filter(value -> !value.equals(BLANK))
                .collect(Collectors.toUnmodifiableList());
        return String.join(DELIMITER, tokens);
    }

    private Symbol findSymbol(final String expression) {
        return Arrays.stream(Symbol.values())
                .filter(targetSymbol -> expression.contains(targetSymbol.getValue()))
                .findAny()
                .orElseThrow();
    }

    private List<Integer> findNumbers(final String expression, final Symbol symbol) {
        List<Integer> numbers = new ArrayList<>();
        int symbolIndex = expression.indexOf(symbol.getValue());
        numbers.add(Integer.parseInt(expression.substring(FIRST_INDEX, symbolIndex)));
        numbers.add(Integer.parseInt(expression.substring(symbolIndex + 1)));
        return numbers;
    }

    public Integer getFirstNumber() {
        return operands.get(FIRST_NUMBER_INDEX);
    }

    public Integer getSecondNumber() {
        return operands.get(SECOND_NUMBER_INDEX);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
