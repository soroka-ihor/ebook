package com.elib.book.model;

import com.elib.author.model.Author;
import com.elib.cover.model.Cover;
import com.elib.db.BaseEntity;
import com.elib.genre.model.Genre;
import com.elib.language.model.Language;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "language_id")
    private Language language;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cover_id")
    private Cover cover;

    @Column(name = "publish_year", columnDefinition = "int")
    private Integer publish_year;

    @Column(name = "isbn", columnDefinition = "varchar(255)")
    private String ISBN;

    @Column(name = "description", columnDefinition = "varchar(255)")
    private String description;

    @Column(name = "file_name", columnDefinition = "varchar(50)")
    private String fileName;
}
