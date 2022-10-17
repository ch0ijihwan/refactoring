package refactor.model.domain;

import refactor.Symbol;
import refactor.model.domain.calculator.*;

import java.util.EnumMap;
import java.util.Map;

public class CalculationGenerator {

    private static final Map<Symbol, Calculation> CALCULATIONS = new EnumMap<>(Symbol.class);

    static {
        CALCULATIONS.put(Symbol.PLUS, new Addition());
        CALCULATIONS.put(Symbol.MINUS, new Subtraction());
        CALCULATIONS.put(Symbol.MULTIPLICATION, new Multiplication());
        CALCULATIONS.put(Symbol.DIVISION, new Division());
    }

    public static Calculation CalculationGeneratorBySymbol(Symbol symbol) {
        return CALCULATIONS.get(symbol);
    }

    private CalculationGenerator(){}
}
