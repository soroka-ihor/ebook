package com.elib.book.dto;

import lombok.Data;

@Data
public class BookDto {
    private String name;
    private String fileName;
    private Long genre_id;
    private Long author_id;
    private Long language_id;
    private Long cover_id;
}
