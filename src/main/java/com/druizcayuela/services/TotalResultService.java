package com.druizcayuela.services;

import com.druizcayuela.domain.RoundResult;
import com.druizcayuela.domain.TotalResult;

public interface TotalResultService extends CrudService<TotalResult> {

    /**
     * Update Total Result with a given round result
     *
     * @param roundResult the round result
     * @return the updated total result
     */
    TotalResult update(final RoundResult roundResult);
}
