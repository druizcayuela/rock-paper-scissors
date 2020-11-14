package com.druizcayuela.controlleres;

import com.druizcayuela.domain.TotalResult;
import com.druizcayuela.services.TotalResultService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TotalResultController.BASE_URL)
public class TotalResultController {

    public static final String BASE_URL = "/api/v1/total";

    private final TotalResultService totalResultService;

    public TotalResultController(TotalResultService totalResultService) {
        this.totalResultService = totalResultService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TotalResult getTotal() {
        return totalResultService.findAll();
    }
}
