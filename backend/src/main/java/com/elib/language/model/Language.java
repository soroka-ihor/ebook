package com.elib.language.model;

import com.elib.book.model.Book;
import com.elib.db.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "languages")
public class Language extends BaseEntity {

    @OneToMany(mappedBy = "language")
    private Set<Book> books;

}
