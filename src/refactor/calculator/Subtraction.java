package refactor.calculator;

public class Subtraction implements Calculation {

    @Override
    public Integer calculate(int x, int y) {
        return x - y;
    }
}
