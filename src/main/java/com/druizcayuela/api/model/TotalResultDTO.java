package com.druizcayuela.api.model;

import lombok.*;

/**
 * The response for the {@link com.druizcayuela.controlleres.TotalResultController}
 *
 * @author druizcayuela
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalResultDTO {

    private Integer roundsPlayed;
    private Integer winsFirstPlayer;
    private Integer winsSecondPlayer;
    private Integer totalDraws;
}
