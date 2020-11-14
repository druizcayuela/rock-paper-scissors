package com.druizcayuela.domain;

/**
 * An enum encapsulating the results of one move.
 *
 * @author druizcayuela
 *
 */

public enum Result {

    ONE_WINS("Player One wins"), TWO_WINS("Player Two wins"), DRAW("DRAW");

    private final String output;

    Result(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
