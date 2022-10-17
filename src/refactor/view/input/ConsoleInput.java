package refactor.view.input;

import refactor.view.DisplayMode;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String inputExpression() {
        return SCANNER.nextLine();
    }

    @Override
    public DisplayMode inputDisplayMode() {
        return DisplayMode.valueOf(SCANNER.nextInt());
    }
}
