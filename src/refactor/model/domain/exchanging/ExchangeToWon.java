package refactor.model.domain.exchanging;

public class ExchangeToWon implements MoneyExchangingMachine {

    @Override
    public Integer exchange(Integer won) {
        return won;
    }
}
