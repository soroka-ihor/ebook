package com.elib.author;

import com.elib.author.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    public Optional<Author> findByName(String name);

}
