package refactor;

import refactor.controller.SimpleCalculator;
import refactor.view.input.ConsoleInput;
import refactor.view.input.Input;
import refactor.view.output.ConsoleOutput;
import refactor.view.output.Output;

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        SimpleCalculator simpleCalculator = new SimpleCalculator();
        simpleCalculator.run(input, output);
    }
}
