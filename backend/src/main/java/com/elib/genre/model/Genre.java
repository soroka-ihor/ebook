package com.elib.genre.model;

import com.elib.book.model.Book;
import com.elib.db.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "genres")
public class Genre extends BaseEntity {

    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id_fk", referencedColumnName = "id")
    private Set<Book> books;

}
