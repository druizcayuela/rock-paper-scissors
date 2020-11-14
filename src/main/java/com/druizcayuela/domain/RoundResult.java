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

    private Move firstPlayerChoice;
    private Move secondPlayerChoice;
    private Result result;
}
