package refactor.controller;

import refactor.Symbol;
import refactor.model.domain.CalculationGenerator;
import refactor.model.domain.ExpressionSplitter;
import refactor.model.domain.calculator.Calculation;
import refactor.model.domain.exchanging.MoneyExchangingMachine;
import refactor.model.domain.exchanging.generator.ExchangeMachineGenerator;
import refactor.model.domain.exchanging.generator.ExchangeType;
import refactor.view.DisplayMode;
import refactor.view.input.Input;
import refactor.view.output.Output;

import static refactor.view.DisplayMode.WON_TO_DOLLAR_TO_BINARY;
import static refactor.view.DisplayMode.WON_TO_DOLLAR_TO_HEX;

public class SimpleCalculator {

    public void run(final Input input, final Output output) {
        String expression = input.inputExpression();
        DisplayMode displayMode = input.inputDisplayMode();

        ExpressionSplitter expressionSplitter = new ExpressionSplitter(expression);
        Symbol symbol = expressionSplitter.getSymbol();
        Integer firstNumber = expressionSplitter.getFirstNumber();
        Integer secondNumber = expressionSplitter.getSecondNumber();

        Integer result = calculate(symbol, firstNumber, secondNumber);
        Integer exchangedResult = exchangeByDisplayMode(result, displayMode);
        output.display(displayMode, exchangedResult);
    }

    private Integer calculate(final Symbol symbol, final Integer firstNumber, final Integer secondNumber) {
        Calculation calculation = CalculationGenerator.getCalculationBy(symbol);
        return calculation.calculate(firstNumber, secondNumber);
    }

    private Integer exchangeByDisplayMode(final Integer result, final DisplayMode displayMode) {
        MoneyExchangingMachine moneyExchangingMachine;
        ExchangeType exchangeType = getExchangeType(displayMode);
        moneyExchangingMachine = ExchangeMachineGenerator.getMoneyExchangingMachineBy(exchangeType);
        return moneyExchangingMachine.exchange(result);
    }

    public ExchangeType getExchangeType(final DisplayMode displayMode) {
        if (displayMode == DisplayMode.WON_TO_DECIMAL || displayMode == DisplayMode.WON_TO_BINARY || displayMode == DisplayMode.WON_TO_HEX) {
            return ExchangeType.TO_WON;
        }
        if (displayMode == DisplayMode.WON_TO_DOLLAR_TO_DECIMAL || displayMode == WON_TO_DOLLAR_TO_BINARY || displayMode == WON_TO_DOLLAR_TO_HEX) {
            return ExchangeType.TO_DOLLAR;
        }
        throw new IllegalStateException("잘못된 접근 입니다.");
    }
}