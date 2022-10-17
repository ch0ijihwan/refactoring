package refactor.view.output;

import refactor.view.DisplayMode;

public class ConsoleOutput implements Output {

    @Override
    public void display(final DisplayMode displayMode, final Integer result) {
        if (displayMode == DisplayMode.WON_TO_DECIMAL || displayMode == DisplayMode.WON_TO_DOLLAR_TO_DECIMAL) {
            System.out.println(result);
        }
        if (displayMode == DisplayMode.WON_TO_BINARY || displayMode == DisplayMode.WON_TO_DOLLAR_TO_BINARY) {
            System.out.println(Integer.toBinaryString(result));
        }
        if (displayMode == DisplayMode.WON_TO_HEX || displayMode == DisplayMode.WON_TO_DOLLAR_TO_HEX) {
            System.out.println(Integer.toHexString(result));
        }
    }
}
