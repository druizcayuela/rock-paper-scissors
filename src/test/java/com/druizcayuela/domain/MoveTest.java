package com.druizcayuela.domain;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MoveTest {

    @Test
    public void beats_rockAgainstScissors_returnTrue() {

        // Given
        final Move move = Move.ROCK;

        //When
        final Move opponentMove = Move.SCISSORS;

        // Then
        assertTrue(move.beats(opponentMove));
    }

    @Test
    public void beats_rockAgainstPaper_returnFalse() {

        // Given
        final Move move = Move.ROCK;

        //When
        final Move opponentMove = Move.PAPER;

        // Then
        assertFalse(move.beats(opponentMove));
    }

    @Test
    public void beats_rockAgainstRock_returnFalse() {

        // Given
        final Move move = Move.ROCK;

        //When
        final Move opponentMove = Move.ROCK;

        // Then
        assertFalse(move.beats(opponentMove));
    }

    @Test
    public void beats_scissorsAgainstPaper_returnTrue() {

        // Given
        final Move move = Move.SCISSORS;

        //When
        final Move opponentMove = Move.PAPER;

        // Then
        assertTrue(move.beats(opponentMove));
    }

    @Test
    public void beats_scissorsAgainstScissors_returnFalse() {

        // Given
        final Move move = Move.SCISSORS;

        //When
        final Move opponentMove = Move.SCISSORS;

        // Then
        assertFalse(move.beats(opponentMove));
    }

    @Test
    public void beats_scissorsAgainstRock_returnFalse() {

        // Given
        final Move move = Move.SCISSORS;

        //When
        final Move opponentMove = Move.ROCK;

        // Then
        assertFalse(move.beats(opponentMove));
    }

    @Test
    public void beats_paperAgainstRock_returnTrue() {

        // Given
        final Move move = Move.PAPER;

        //When
        final Move opponentMove = Move.ROCK;

        // Then
        assertTrue(move.beats(opponentMove));
    }

    @Test
    public void beats_paperAgainstScissors_returnFalse() {

        // Given
        final Move move = Move.PAPER;

        //When
        final Move opponentMove = Move.SCISSORS;

        // Then
        assertFalse(move.beats(opponentMove));
    }

    @Test
    public void beats_paperAgainstPaper_returnFalse() {

        // Given
        final Move move = Move.PAPER;

        //When
        final Move opponentMove = Move.PAPER;

        // Then
        assertFalse(move.beats(opponentMove));
    }
}
