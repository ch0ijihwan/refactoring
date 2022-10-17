package refactor.controller;

import refactor.MoneyChangingMachine;
import refactor.Symbol;
import refactor.model.domain.CalculationGenerator;
import refactor.model.domain.ExpressionSplitter;
import refactor.model.domain.calculator.Calculation;

import java.util.Scanner;

public class SimpleCalculator {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String input = SCANNER.nextLine();
        ExpressionSplitter expressionSplitter = new ExpressionSplitter(input);

        Symbol symbol = expressionSplitter.getSymbol();
        Integer firstNumber = expressionSplitter.getFirstNumber();
        Integer secondNumber = expressionSplitter.getSecondNumber();

        Calculation calculation = CalculationGenerator.CalculationGeneratorBySymbol(symbol);
        Integer result = calculation.calculate(firstNumber, secondNumber);

        MoneyChangingMachine moneyChangingMachine = new MoneyChangingMachine();

        int displayMode = 0;
        switch (displayMode) {
            case 0:
                System.out.print(moneyChangingMachine.exchangeWonToDecimal(result));
                break;
            case 1:
                System.out.print(moneyChangingMachine.exchangeWonToBinary(result));
                break;
            case 2:
                System.out.print(moneyChangingMachine.exchangeWonToHex(result));
                break;
            case 3:
                System.out.print(moneyChangingMachine.exchangeWonToDollarToDecimal(result));
                break;
            case 4:
                System.out.print(moneyChangingMachine.exchangeWonToDollarToBinary(result));
                break;
            case 5:
                System.out.print(moneyChangingMachine.exchangeWonToDollarToHex(result));
                break;
        }

        SCANNER.close();
    }
}