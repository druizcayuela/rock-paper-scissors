package com.druizcayuela.domain;

import lombok.*;

/**
 * The response for the PlayGround Controller
 *
 * @author druizcayuela
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundResult {

    private String firstPlayerChoice;
    private String secondPlayerChoice;
    private String result;
}
