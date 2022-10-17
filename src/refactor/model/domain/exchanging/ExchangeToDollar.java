package refactor.model.domain.exchanging;

public class ExchangeToDollar implements MoneyExchangingMachine {

    private static final double DOLLAR_EXCHANGE_RATE = 1434.0;

    @Override
    public Integer exchange(Integer won) {
        return changeWonToDollar(won);
    }

    private int changeWonToDollar(Integer won) {
        return (int) (Math.round((won / DOLLAR_EXCHANGE_RATE)));
    }
}
