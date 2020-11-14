package com.druizcayuela.domain;

/**
 * The moves
 *
 * @author druizcayuela
 *
 */
public enum Move {

    ROCK, PAPER, SCISSORS;

    /**
     * Check in the move is beating with the given move
     *
     * @param opponentMove the opponent move
     * @return if the move wins
     */
    boolean beats(Move opponentMove) {
        switch (this) {
            case ROCK:
                return opponentMove == SCISSORS;
            case PAPER:
                return opponentMove == ROCK;
            case SCISSORS:
                return opponentMove == PAPER;
            default:
                throw new IllegalStateException();
        }
    }
}
