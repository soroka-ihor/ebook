package com.elib.genre;

import com.elib.genre.dto.GenreDto;
import com.elib.genre.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper MAPPER = Mappers.getMapper(GenreMapper.class);

    @Mapping(source = "id", target = "genreId")
    @Mapping(source = "name", target = "genreName")
    GenreDto genreToGenreDto(Genre genre);

    @Mapping(source = "genreId", target = "id")
    @Mapping(source = "genreName", target = "name")
    Genre genreDtoToGenre(GenreDto genre);
}
