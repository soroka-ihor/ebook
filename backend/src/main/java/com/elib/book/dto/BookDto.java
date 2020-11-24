package com.elib.book.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String genre;
    private String name;
    private String author;
    private int year;
    private String language;
    private String description;
    private String contentUrl;
}
