package com.druizcayuela.services;

import com.druizcayuela.domain.Move;
import com.druizcayuela.domain.RoundResult;

/**
 * The Rounds Result Service
 *
 * @author druizcayuela
 *
 */

public interface RoundResultService extends CrudService<RoundResult>{

    /**
     * Although it's specified that second player always will be ROCK, I cannot hardcode my
     * algorithm of checking who is the win
     *
     * @param onePlayerMove the one player move
     * @param secondPlayerMove the second player move
     * @return the round result
     */
    RoundResult evaluateMoves(final Move onePlayerMove, final Move secondPlayerMove);
}
