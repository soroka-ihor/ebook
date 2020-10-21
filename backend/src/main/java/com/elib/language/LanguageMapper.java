package com.elib.language;

import com.elib.language.dto.LanguageDto;
import com.elib.language.model.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {

    LanguageMapper MAPPER = Mappers.getMapper(LanguageMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "languageName")
    LanguageDto languageToLanguageDto(Language language);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "languageName", target = "name")
    Language languageDtoToLanguage(LanguageDto language);
}
