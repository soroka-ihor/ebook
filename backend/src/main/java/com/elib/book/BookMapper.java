package com.elib.book;

import com.elib.book.dto.BookDto;
import com.elib.book.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "genre.name", target = "genre")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "author.name", target = "author")
    @Mapping(source = "publish_year", target = "year")
    @Mapping(source = "language.name", target = "language")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "fileName", target = "contentUrl")
    @Mapping(source = "cover.id", target = "coverId")
    BookDto bookToBookDto(Book book);

}
