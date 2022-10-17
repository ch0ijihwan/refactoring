package refactor.model.domain.calculator;

public class Addition implements Calculation {
    @Override
    public Integer calculate(final int x, final int y) {
        return x + y;
    }
}
