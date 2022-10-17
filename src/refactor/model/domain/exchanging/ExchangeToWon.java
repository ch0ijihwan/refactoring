package refactor.model.domain.exchanging;

public class ExchangeToWon implements MoneyExchangingMachine {

    @Override
    public Integer exchange(final Integer won) {
        return won;
    }
}
