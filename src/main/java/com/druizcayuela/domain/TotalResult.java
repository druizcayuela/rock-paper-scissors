package com.druizcayuela.domain;

import lombok.*;

/**
 * The response for the Total Controller
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
