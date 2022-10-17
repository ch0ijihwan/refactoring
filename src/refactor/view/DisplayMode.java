package refactor.view;

import java.util.Arrays;

public enum DisplayMode {

    WON_TO_DECIMAL(0),
    WON_TO_BINARY(1),
    WON_TO_HEX(2),
    WON_TO_DOLLAR_TO_DECIMAL(3),
    WON_TO_DOLLAR_TO_BINARY(4),
    WON_TO_DOLLAR_TO_HEX(5);

    private final int value;

    DisplayMode(final int value) {
        this.value = value;
    }

    public static DisplayMode valueOf(final int modeNumber) {
        return Arrays.stream(DisplayMode.values())
                .filter(mode -> mode.value == modeNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 모드입니다."));
    }
}
