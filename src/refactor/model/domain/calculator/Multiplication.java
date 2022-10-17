package refactor.model.domain.calculator;

public class Multiplication implements Calculation {

    @Override
    public Integer calculate(int x, int y) {
        return x * y;
    }
}
