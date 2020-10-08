package com.elib.author;

import com.elib.author.model.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByName(String name);

    @Modifying(flushAutomatically = true)
    @Query("UPDATE Author author SET author.name = :name WHERE author.id = :id")
    void updateName(@Param(value = "id") Long id, @Param(value = "name") String name);
}
