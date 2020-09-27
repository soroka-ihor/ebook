package com.elib.language.model;

import com.elib.book.model.Book;
import com.elib.db.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "languages")
public class Language extends BaseEntity {

    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id_fk", referencedColumnName = "id")
    private Set<Book> books;

}
