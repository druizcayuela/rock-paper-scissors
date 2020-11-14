package com.druizcayuela.domain;

/**
 * The superclass of all players
 *
 * @author druizcayuela
 *
 */
public abstract class Player {

    /**
     * Generates the next move
     *
     * @return the next move
     */
    public abstract Move getNextMove();
}
