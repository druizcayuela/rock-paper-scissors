package com.druizcayuela.api.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundResultDTO {

    private String firstPlayerChoice;
    private String secondPlayerChoice;
    private String result;
}
