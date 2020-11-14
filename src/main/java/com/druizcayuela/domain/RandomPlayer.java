package com.druizcayuela.domain;

import lombok.Builder;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A player that always returns a random move
 *
 * @author druizcayuela
 *
 */
@Builder
public class RandomPlayer extends Player {

    @Override
    public Move getNextMove() {
        return Move.values()[ThreadLocalRandom.current().nextInt(0, Move.values().length)];
    }
}
