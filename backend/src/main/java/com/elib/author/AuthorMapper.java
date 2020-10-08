package com.elib.author;

import com.elib.author.dto.AuthorDto;
import com.elib.author.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "authorName")
    AuthorDto authorToAuthorDto(Author author);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "authorName", target = "name")
    Author authorDtoToAuthor(AuthorDto author);
}
