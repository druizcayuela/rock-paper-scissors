package com.druizcayuela.domain;

import lombok.*;

/**
 * The Total result
 *
 * @author druizcayuela
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalResult {

    private Integer roundsPlayed;
    private Integer winsFirstPlayer;
    private Integer winsSecondPlayer;
    private Integer totalDraws;
}
