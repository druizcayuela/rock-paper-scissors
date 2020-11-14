package com.druizcayuela.controlleres;

import com.druizcayuela.api.mapper.RoundResultMapper;
import com.druizcayuela.api.model.RoundResultDTO;
import com.druizcayuela.domain.RandomPlayer;
import com.druizcayuela.domain.RockPlayer;
import com.druizcayuela.domain.RoundResult;
import com.druizcayuela.services.RoundResultService;
import com.druizcayuela.services.TotalResultService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PlayRoundController.BASE_URL)
public class PlayRoundController {

    public static final String BASE_URL = "/api/v1/playround";

    private final RoundResultService roundResultService;
    private final TotalResultService totalResultService;
    private final RoundResultMapper roundResultMapper;

    public PlayRoundController(RoundResultService roundResultService, TotalResultService totalResultService, RoundResultMapper roundResultMapper) {
        this.roundResultService = roundResultService;
        this.totalResultService = totalResultService;
        this.roundResultMapper = roundResultMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RoundResultDTO playRound() {

        RoundResult roundResult = roundResultService.evaluateMoves(
                RandomPlayer.builder().build().getNextMove(),
                RockPlayer.builder().build().getNextMove()
        );

        totalResultService.update(roundResult);

        return roundResultMapper.roundResultToRoundResultDTO(roundResult);
    }
}
