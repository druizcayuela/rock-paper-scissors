package com.druizcayuela.services.memory;

import com.druizcayuela.domain.Result;
import com.druizcayuela.domain.RoundResult;
import com.druizcayuela.domain.TotalResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TotalResultMemoryServiceTest {

    private TotalResultMemoryService totalResultMemoryService;

    private final int INITIAL_ROUNDS_PLAYED = 3;
    private final int INITIAL_WINS_FIRST_PLAYER = 1;
    private final int INITIAL_WINS_SECOND_PLAYER = 1;
    private final int INITIAL_TOTAL_DRAWS = 1;


    @Before
    public void setUp() {

        totalResultMemoryService = new TotalResultMemoryService();
        totalResultMemoryService.save(TotalResult.builder()
                .roundsPlayed(INITIAL_ROUNDS_PLAYED)
                .winsFirstPlayer(INITIAL_WINS_FIRST_PLAYER)
                .winsSecondPlayer(INITIAL_WINS_SECOND_PLAYER)
                .totalDraws(INITIAL_TOTAL_DRAWS)
                .build());
    }

    @Test
    public void findObject_returnTheCorrectData() {

        // Given - When
        TotalResult totalResult = totalResultMemoryService.findObject();

        // Then
        assertNotNull(totalResult);
        assertEquals(Integer.valueOf(INITIAL_ROUNDS_PLAYED), totalResult.getRoundsPlayed());
        assertEquals(Integer.valueOf(INITIAL_WINS_FIRST_PLAYER), totalResult.getWinsFirstPlayer());
        assertEquals(Integer.valueOf(INITIAL_WINS_SECOND_PLAYER), totalResult.getWinsSecondPlayer());
        assertEquals(Integer.valueOf(INITIAL_TOTAL_DRAWS), totalResult.getTotalDraws());
    }

    @Test
    public void save_returnTheCorrectData() {

        // Given - When
        TotalResult totalResult = totalResultMemoryService.save(TotalResult.builder()
                .roundsPlayed(10)
                .winsFirstPlayer(4)
                .winsSecondPlayer(4)
                .totalDraws(2)
                .build());

        // Then
        assertNotNull(totalResult);
        assertEquals(Integer.valueOf(10), totalResult.getRoundsPlayed());
        assertEquals(Integer.valueOf(4), totalResult.getWinsFirstPlayer());
        assertEquals(Integer.valueOf(4), totalResult.getWinsSecondPlayer());
        assertEquals(Integer.valueOf(2), totalResult.getTotalDraws());
    }

    @Test
    public void update_winsPlayer1() {

        // Given
        RoundResult roundResult = RoundResult.builder()
                .result(Result.ONE_WINS)
                .build();

        // When
        TotalResult totalResult = totalResultMemoryService.update(roundResult);

        // Then
        assertNotNull(totalResult);
        assertEquals(Integer.valueOf(INITIAL_ROUNDS_PLAYED + 1), totalResult.getRoundsPlayed());
        assertEquals(Integer.valueOf(INITIAL_WINS_FIRST_PLAYER + 1), totalResult.getWinsFirstPlayer());
        assertEquals(Integer.valueOf(INITIAL_WINS_SECOND_PLAYER), totalResult.getWinsSecondPlayer());
        assertEquals(Integer.valueOf(INITIAL_TOTAL_DRAWS), totalResult.getTotalDraws());
    }

    @Test
    public void update_winsPlayer2() {

        // Given
        RoundResult roundResult = RoundResult.builder()
                .result(Result.TWO_WINS)
                .build();

        // When
        TotalResult totalResult = totalResultMemoryService.update(roundResult);

        // Then
        assertNotNull(totalResult);
        assertEquals(Integer.valueOf(INITIAL_ROUNDS_PLAYED + 1), totalResult.getRoundsPlayed());
        assertEquals(Integer.valueOf(INITIAL_WINS_FIRST_PLAYER), totalResult.getWinsFirstPlayer());
        assertEquals(Integer.valueOf(INITIAL_WINS_SECOND_PLAYER + 1), totalResult.getWinsSecondPlayer());
        assertEquals(Integer.valueOf(INITIAL_TOTAL_DRAWS), totalResult.getTotalDraws());
    }

    @Test
    public void update_draw() {

        // Given
        RoundResult roundResult = RoundResult.builder()
                .result(Result.DRAW)
                .build();

        // When
        TotalResult totalResult = totalResultMemoryService.update(roundResult);

        // Then
        assertNotNull(totalResult);
        assertEquals(Integer.valueOf(INITIAL_ROUNDS_PLAYED + 1), totalResult.getRoundsPlayed());
        assertEquals(Integer.valueOf(INITIAL_WINS_FIRST_PLAYER), totalResult.getWinsFirstPlayer());
        assertEquals(Integer.valueOf(INITIAL_WINS_SECOND_PLAYER), totalResult.getWinsSecondPlayer());
        assertEquals(Integer.valueOf(INITIAL_TOTAL_DRAWS + 1), totalResult.getTotalDraws());
    }
}