package com.druizcayuela.services.memory;

import com.druizcayuela.domain.Move;
import com.druizcayuela.domain.Result;
import com.druizcayuela.domain.RoundResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundResultMemoryServiceTest {

    private RoundResultMemoryService roundResultMemoryService;


    @Before
    public void setUp() throws Exception {
        roundResultMemoryService = new RoundResultMemoryService();
    }

    @Test
    public void evaluateMoves_winPlayerOne() {

        // Given
        Move playerOne = Move.PAPER;
        Move playerTwo = Move.ROCK;

        // When
        RoundResult roundResult = roundResultMemoryService.evaluateMoves(playerOne, playerTwo);

        // Then
        assertEquals(Result.ONE_WINS, roundResult.getResult());
        assertEquals(playerOne, roundResult.getFirstPlayerChoice());
        assertEquals(playerTwo, roundResult.getSecondPlayerChoice());
    }

    @Test
    public void evaluateMoves_winPlayerTwo() {

        // Given
        Move playerOne = Move.SCISSORS;
        Move playerTwo = Move.ROCK;

        // When
        RoundResult roundResult = roundResultMemoryService.evaluateMoves(playerOne, playerTwo);

        // Then
        assertEquals(Result.TWO_WINS, roundResult.getResult());
        assertEquals(playerOne, roundResult.getFirstPlayerChoice());
        assertEquals(playerTwo, roundResult.getSecondPlayerChoice());
    }

    @Test
    public void evaluateMoves_draw() {

        // Given
        Move playerOne = Move.ROCK;
        Move playerTwo = Move.ROCK;

        // When
        RoundResult roundResult = roundResultMemoryService.evaluateMoves(playerOne, playerTwo);

        // Then
        assertEquals(Result.DRAW, roundResult.getResult());
        assertEquals(playerOne, roundResult.getFirstPlayerChoice());
        assertEquals(playerTwo, roundResult.getSecondPlayerChoice());
    }
}