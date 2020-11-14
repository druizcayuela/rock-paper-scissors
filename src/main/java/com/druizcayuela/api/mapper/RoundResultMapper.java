package com.druizcayuela.api.mapper;

import com.druizcayuela.api.model.RoundResultDTO;
import com.druizcayuela.domain.RoundResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RoundResultMapper {

    RoundResultMapper INSTANCE = Mappers.getMapper(RoundResultMapper.class);

    @Mappings({
            @Mapping(source = "firstPlayerChoice.output", target = "firstPlayerChoice"),
            @Mapping(source = "secondPlayerChoice.output", target = "secondPlayerChoice"),
            @Mapping(source = "result.output", target = "result"),
    })
    RoundResultDTO roundResultToRoundResultDTO(RoundResult roundResult);
}
