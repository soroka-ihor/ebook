package com.elib.cover;

import com.elib.cover.dto.CoverDto;
import com.elib.cover.model.Cover;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoverMapper {
    CoverMapper MAPPER = Mappers.getMapper(CoverMapper.class);

    @Mapping(source = "id", target = "coverId")
    @Mapping(source = "name", target = "coverType")
    CoverDto coverToCoverDto(Cover cover);

    @Mapping(source = "coverType", target = "name")
    Cover coverDtoToSave(CoverDto coverDto);
}
