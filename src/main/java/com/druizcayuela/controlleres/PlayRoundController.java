package com.druizcayuela.controlleres;

import com.druizcayuela.api.mapper.RoundResultMapper;
import com.druizcayuela.api.model.RoundResultDTO;
import com.druizcayuela.domain.RandomPlayer;
import com.druizcayuela.domain.RockPlayer;
import com.druizcayuela.domain.RoundResult;
import com.druizcayuela.services.RoundResultService;
import com.druizcayuela.services.TotalResultService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * The controller for Play Ground
 *
 * @author druizcayuela
 *
 */

@RestController
@CrossOrigin
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

    /**
     * Play a round with a {@link RandomPlayer} as player 1 and {@link RockPlayer} as player 2.
     * Also needs to update to total result.
     *
     * @return the result of this round
     */
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
