package com.druizcayuela.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RockPlayerTest {

    @Test
    public void getNextMove_returnRock(){

        // Given
        RockPlayer rockPlayer = RockPlayer.builder().build();

        // When
        Move playerMove = rockPlayer.getNextMove();

        // Then
        assertEquals(Move.ROCK, playerMove);
    }
}
