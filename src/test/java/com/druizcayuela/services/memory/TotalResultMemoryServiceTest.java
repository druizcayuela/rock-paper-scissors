package com.druizcayuela.services.memory;

import com.druizcayuela.domain.TotalResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TotalResultMemoryServiceTest {

    private TotalResultMemoryService totalResultMemoryService;


    @Before
    public void setUp() {

        totalResultMemoryService = new TotalResultMemoryService();
        totalResultMemoryService.save(TotalResult.builder()
                .roundsPlayed(3)
                .winsFirstPlayer(1)
                .winsSecondPlayer(1)
                .totalDraws(1)
                .build());
    }

    @Test
    public void findAll_returnTheCorrectData() {

        // Given - When
        TotalResult totalResult = totalResultMemoryService.findAll();

        // Then
        assertNotNull(totalResult);
        assertEquals(Integer.valueOf(3), totalResult.getRoundsPlayed());
        assertEquals(Integer.valueOf(1), totalResult.getWinsFirstPlayer());
        assertEquals(Integer.valueOf(1), totalResult.getWinsSecondPlayer());
        assertEquals(Integer.valueOf(1), totalResult.getTotalDraws());
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
}