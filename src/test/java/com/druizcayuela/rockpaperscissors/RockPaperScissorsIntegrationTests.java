package com.druizcayuela.rockpaperscissors;

import com.druizcayuela.controlleres.PlayRoundController;
import com.druizcayuela.controlleres.TotalResultController;
import com.druizcayuela.domain.Move;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RockPaperScissorsIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void playTwoRounds_getTotalResult_shouldReturnOKAndTwoRounds() throws Exception {

        // Given
        // Real application context

        // When
        // First round
        mockMvc.perform(get(PlayRoundController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.secondPlayerChoice").value(Move.ROCK.getOutput()));

        // Second round
        mockMvc.perform(get(PlayRoundController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.secondPlayerChoice").value(Move.ROCK.getOutput()));

        //Then
        mockMvc.perform(get(TotalResultController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roundsPlayed").value(2));
    }
}
