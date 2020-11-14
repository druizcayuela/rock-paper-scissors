package com.druizcayuela.services.memory;

import com.druizcayuela.domain.Move;
import com.druizcayuela.domain.Result;
import com.druizcayuela.domain.RoundResult;
import com.druizcayuela.services.RoundResultService;
import org.springframework.stereotype.Service;

/**
 * The round memory service bean
 *
 * @author druizcayuela
 *
 */

@Service
public class RoundResultMemoryService extends AbstractMemoryService<RoundResult> implements RoundResultService {

    @Override
    public RoundResult evaluateMoves(Move onePlayerMove, Move secondPlayerMove) {

        Result result;

        if (onePlayerMove.beats(secondPlayerMove)) {
            result = Result.ONE_WINS;
        } else if (secondPlayerMove.beats(onePlayerMove)) {
            result = Result.TWO_WINS;
        } else {
            result = Result.DRAW;
        }

        return RoundResult.builder()
                .firstPlayerChoice(onePlayerMove)
                .secondPlayerChoice(secondPlayerMove)
                .result(result)
                .build();
    }
}
