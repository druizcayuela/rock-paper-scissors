package com.druizcayuela.api.mapper;

import com.druizcayuela.api.model.RoundResultDTO;
import com.druizcayuela.domain.Move;
import com.druizcayuela.domain.Result;
import com.druizcayuela.domain.RoundResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundResultMapperTest {

    RoundResultMapper roundResultMapper = RoundResultMapper.INSTANCE;

    @Test
    public void roundResultToRoundResultDTO() {

        // Given
        RoundResult roundResult = RoundResult.builder()
                .firstPlayerChoice(Move.PAPER)
                .secondPlayerChoice(Move.ROCK)
                .result(Result.ONE_WINS)
                .build();

        // When
        RoundResultDTO roundResultDTO = roundResultMapper.roundResultToRoundResultDTO(roundResult);

        // Then
        assertEquals(roundResult.getFirstPlayerChoice().getOutput(), roundResultDTO.getFirstPlayerChoice());
        assertEquals(roundResult.getSecondPlayerChoice().getOutput(), roundResultDTO.getSecondPlayerChoice());
        assertEquals(roundResult.getResult().getOutput(), roundResultDTO.getResult());
    }
}