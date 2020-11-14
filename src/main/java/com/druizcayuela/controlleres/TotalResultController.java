package com.druizcayuela.controlleres;

import com.druizcayuela.api.mapper.TotalResultMapper;
import com.druizcayuela.api.model.TotalResultDTO;
import com.druizcayuela.services.TotalResultService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller for Total Result
 *
 * @author druizcayuela
 *
 */

@RestController
@RequestMapping(TotalResultController.BASE_URL)
public class TotalResultController {

    public static final String BASE_URL = "/api/v1/total";

    private final TotalResultService totalResultService;
    private final TotalResultMapper totalResultMapper;

    public TotalResultController(TotalResultService totalResultService, TotalResultMapper totalResultMapper) {
        this.totalResultService = totalResultService;
        this.totalResultMapper = totalResultMapper;
    }

    /**
     * Get the total result of all the games
     *
     * @return the total result
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TotalResultDTO getTotal() {
        return totalResultMapper.totalResultToTotalResultDTO(totalResultService.findAll());
    }
}
