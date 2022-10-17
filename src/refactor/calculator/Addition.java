package refactor.calculator;

public class Addition implements Calculation {
    @Override
    public Integer calculate(int x, int y) {
        return x + y;
    }
}
