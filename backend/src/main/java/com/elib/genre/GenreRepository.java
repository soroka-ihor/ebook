package com.elib.genre;

import com.elib.genre.model.Genre;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    Optional<Genre> findByName(String name);

    @Modifying(flushAutomatically = true)
    @Query("UPDATE Genre genre SET genre.name = :name WHERE genre.id = :id")
    void updateName(@Param(value = "id") Long id, @Param(value = "name") String name);
}
