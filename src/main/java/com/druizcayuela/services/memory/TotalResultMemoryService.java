package com.druizcayuela.services.memory;

import com.druizcayuela.domain.Result;
import com.druizcayuela.domain.RoundResult;
import com.druizcayuela.domain.TotalResult;
import com.druizcayuela.services.TotalResultService;
import org.springframework.stereotype.Service;

/**
 * The result memory service bean
 *
 * @author druizcayuela
 *
 */

@Service
public class TotalResultMemoryService extends AbstractMemoryService<TotalResult> implements TotalResultService {

    @Override
    public TotalResult update(RoundResult roundResult) {

        TotalResult totalResult = this.findObject();

        totalResult.setRoundsPlayed(totalResult.getRoundsPlayed() + 1);

        if (roundResult.getResult().equals(Result.ONE_WINS)) {
            totalResult.setWinsFirstPlayer(totalResult.getWinsFirstPlayer() + 1);
        } else if (roundResult.getResult().equals(Result.TWO_WINS)) {
            totalResult.setWinsSecondPlayer(totalResult.getWinsSecondPlayer() + 1);
        } else if (roundResult.getResult().equals(Result.DRAW)) {
            totalResult.setTotalDraws(totalResult.getTotalDraws() + 1);
        }
        return this.save(totalResult);
    }
}
