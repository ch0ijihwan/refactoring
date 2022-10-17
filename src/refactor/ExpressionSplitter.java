package refactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionSplitter {


    private final List<Integer> operands;
    private final Symbol symbol;

    public ExpressionSplitter(String expression) {
        String noneBlankExpression = removeBlanks(expression);
        symbol = findSymbol(noneBlankExpression);
        operands = findNumbers(noneBlankExpression, symbol);
    }

    private String removeBlanks(String expression) {

        List<String> tokens = Arrays.stream(expression.split(""))
                .filter(value -> !value.equals(" "))
                .collect(Collectors.toUnmodifiableList());
        return String.join("", tokens);
    }


    private Symbol findSymbol(String expression) {
        return Arrays.stream(Symbol.values())
                .filter(targetSymbol -> expression.contains(targetSymbol.getValue()))
                .findAny()
                .orElseThrow();
    }

    private List<Integer> findNumbers(String expression, Symbol symbol) {
        List<Integer> numbers = new ArrayList<>();
        int symbolIndex = expression.indexOf(symbol.getValue());
        numbers.add(Integer.parseInt(expression.substring(0, symbolIndex)));
        numbers.add(Integer.parseInt(expression.substring(symbolIndex)));
        return numbers;
    }

    public Integer getFirstNumber() {
        return operands.get(0);
    }

    public Integer getSecondNumber() {
        return operands.get(1);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
