package com.elib.tag.model;

import com.elib.book.model.Book;
import com.elib.db.BaseEntity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tags")
public class Tag extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
