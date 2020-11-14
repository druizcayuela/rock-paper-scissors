package com.druizcayuela.controlleres;

import com.druizcayuela.domain.Move;
import com.druizcayuela.domain.Result;
import com.druizcayuela.domain.RoundResult;
import com.druizcayuela.services.RoundResultService;
import com.druizcayuela.services.TotalResultService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlayRoundControllerTest {

    @Mock
    RoundResultService roundResultService;

    @Mock
    TotalResultService totalResultService;

    @InjectMocks
    PlayRoundController playRoundController;

    MockMvc mockMvc;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(playRoundController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler()).build();
    }

    @Test
    public void playRound() throws Exception {

        RoundResult roundResult = RoundResult.builder()
                .firstPlayerChoice(Move.PAPER.getOutput())
                .secondPlayerChoice(Move.ROCK.getOutput())
                .result(Result.ONE_WINS.getOutput())
                .build();

        when(roundResultService.evaluateMoves(any(Move.class), any(Move.class))).thenReturn(roundResult);
        when(totalResultService.update(any(RoundResult.class))).thenReturn(null);

        mockMvc.perform(get(PlayRoundController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", equalTo(roundResult.getResult())))
                .andExpect(jsonPath("$.firstPlayerChoice", equalTo(roundResult.getFirstPlayerChoice())))
                .andExpect(jsonPath("$.secondPlayerChoice", equalTo(roundResult.getSecondPlayerChoice())));
    }
}