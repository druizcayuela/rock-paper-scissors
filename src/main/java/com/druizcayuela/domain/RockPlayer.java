package com.druizcayuela.domain;

import lombok.Builder;

/**
 * A player that always returns a {@link Move#ROCK} move
 *
 * @author druizcayuela
 *
 */
@Builder
public class RockPlayer extends Player{

    @Override
    public Move getNextMove() {
        return Move.ROCK;
    }
}
