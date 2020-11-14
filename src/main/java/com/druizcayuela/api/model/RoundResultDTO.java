package com.druizcayuela.api.model;

import lombok.*;

/**
 * The response for the {@link com.druizcayuela.controlleres.PlayRoundController}
 *
 * @author druizcayuela
 *
 */

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
