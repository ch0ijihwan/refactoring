package refactor.model.domain.calculator;

public class Division implements Calculation {

    @Override
    public Integer calculate(int x, int y) {
        validateDivision(y);
        return x / y;
    }

    private void validateDivision(int y) {
        if (y == 0) {
            throw new IllegalArgumentException("나눔 수는 0이 될 수 없습니다.");
        }
    }
}
