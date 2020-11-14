package com.druizcayuela.controlleres;

import com.druizcayuela.domain.TotalResult;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TotalResultControllerTest {

    @Mock
    TotalResultService totalResultService;

    @InjectMocks
    TotalResultController totalResultController;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(totalResultController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler()).build();
    }

    @Test
    public void getTotal() throws Exception {

        TotalResult totalResult = TotalResult.builder()
                .roundsPlayed(5)
                .winsFirstPlayer(2)
                .winsSecondPlayer(2)
                .totalDraws(1)
                .build();

        when(totalResultService.findAll()).thenReturn(totalResult);

        mockMvc.perform(get(TotalResultController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roundsPlayed", equalTo(totalResult.getRoundsPlayed())))
                .andExpect(jsonPath("$.winsFirstPlayer", equalTo(totalResult.getWinsFirstPlayer())))
                .andExpect(jsonPath("$.winsSecondPlayer", equalTo(totalResult.getWinsSecondPlayer())))
                .andExpect(jsonPath("$.totalDraws", equalTo(totalResult.getTotalDraws())));
    }
}