package com.elib.author.model;

import com.elib.book.model.Book;
import com.elib.db.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "authors")
public class Author extends BaseEntity  {

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

}
