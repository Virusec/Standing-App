package org.example.mapper;

import org.example.model.domain.Match;
import org.example.model.dto.MatchDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Anatoliy Shikin
 */
@Mapper(componentModel = "spring")
public interface MatchMapper {

    @Mapping(target = "id", ignore = true)
    Match toEntity(MatchDto matchDto);

    MatchDto toDto(Match match);
}
