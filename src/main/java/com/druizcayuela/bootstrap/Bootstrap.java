package com.druizcayuela.bootstrap;

import com.druizcayuela.domain.TotalResult;
import com.druizcayuela.services.TotalResultService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TotalResultService totalResultService;

    public Bootstrap(TotalResultService totalResultService) {
        this.totalResultService = totalResultService;
    }

    @Override
    public void run(String... args) throws Exception {
        totalResultService.save(TotalResult.builder()
                .roundsPlayed(0)
                .winsFirstPlayer(0)
                .winsSecondPlayer(0)
                .totalDraws(0)
                .build());
    }
}
