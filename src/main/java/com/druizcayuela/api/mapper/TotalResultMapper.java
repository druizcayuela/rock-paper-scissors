package com.druizcayuela.api.mapper;

import com.druizcayuela.api.model.TotalResultDTO;
import com.druizcayuela.domain.TotalResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TotalResultMapper {

    TotalResultMapper INSTANCE = Mappers.getMapper(TotalResultMapper.class);

    TotalResultDTO totalResultToTotalResultDTO(TotalResult totalResult);
}
