package com.druizcayuela.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RandomPlayerTest {

    @Test
    public void getNextMove_returnACorrectMove() {

        // Given
        RandomPlayer randomPlayer = RandomPlayer.builder().build();

        // When
        Move move = randomPlayer.getNextMove();

        // Then
        assertTrue(Arrays.asList(Move.values()).contains(move));
    }
}
