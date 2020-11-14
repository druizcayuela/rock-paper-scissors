package com.druizcayuela.api.mapper;

import com.druizcayuela.api.model.TotalResultDTO;
import com.druizcayuela.domain.TotalResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TotalResultMapperTest {

    TotalResultMapper totalResultMapper = TotalResultMapper.INSTANCE;

    @Test
    public void totalResultToTotalResultDTO() {

        // Given
        TotalResult totalResult = TotalResult.builder()
                .roundsPlayed(10)
                .winsFirstPlayer(4)
                .winsSecondPlayer(4)
                .totalDraws(2)
                .build();

        // When
        TotalResultDTO totalResultDTO = totalResultMapper.totalResultToTotalResultDTO(totalResult);

        // Then
        assertEquals(totalResultDTO.getRoundsPlayed(), totalResultDTO.getRoundsPlayed());
        assertEquals(totalResultDTO.getWinsFirstPlayer(), totalResultDTO.getWinsFirstPlayer());
        assertEquals(totalResultDTO.getWinsSecondPlayer(), totalResultDTO.getWinsSecondPlayer());
        assertEquals(totalResultDTO.getTotalDraws(), totalResultDTO.getTotalDraws());
    }
}