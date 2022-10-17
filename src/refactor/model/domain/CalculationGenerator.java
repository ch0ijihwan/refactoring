package refactor.model.domain;

import refactor.model.domain.calculator.*;

import java.util.EnumMap;
import java.util.Map;

public class CalculationGenerator {

    private static final Map<Symbol, Calculation> CALCULATIONS_MAP = new EnumMap<>(Symbol.class);

    static {
        CALCULATIONS_MAP.put(Symbol.PLUS, new Addition());
        CALCULATIONS_MAP.put(Symbol.MINUS, new Subtraction());
        CALCULATIONS_MAP.put(Symbol.MULTIPLICATION, new Multiplication());
        CALCULATIONS_MAP.put(Symbol.DIVISION, new Division());
    }

    public static Calculation getCalculationBy(final Symbol symbol) {
        return CALCULATIONS_MAP.get(symbol);
    }

    private CalculationGenerator(){}
}
