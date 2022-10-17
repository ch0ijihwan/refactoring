package refactor.model.domain.exchanging.generator;

import refactor.model.domain.exchanging.ExchangeToDollar;
import refactor.model.domain.exchanging.ExchangeToWon;
import refactor.model.domain.exchanging.MoneyExchangingMachine;

import java.util.EnumMap;
import java.util.Map;

public class ExchangeMachineGenerator {

    private static final Map<ExchangeType, MoneyExchangingMachine> EXCHANGING_MACHINE_MAP = new EnumMap<>(ExchangeType.class);

    static {
        EXCHANGING_MACHINE_MAP.put(ExchangeType.TO_WON, new ExchangeToWon());
        EXCHANGING_MACHINE_MAP.put(ExchangeType.TO_DOLLAR, new ExchangeToDollar());
    }

    public static MoneyExchangingMachine getMoneyExchangingMachineBy(final ExchangeType exchangeType) {
        return EXCHANGING_MACHINE_MAP.get(exchangeType);
    }

    private ExchangeMachineGenerator() {
    }
}
