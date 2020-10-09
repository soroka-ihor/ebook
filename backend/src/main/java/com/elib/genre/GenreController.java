package com.elib.genre;

import com.elib.exception.GenreNotFoundException;
import com.elib.genre.dto.GenreDto;
import com.elib.genre.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService service;

    @PostMapping
    public ResponseEntity<GenreDto> save(@RequestParam("name") String name) {
        Genre genre = new Genre();
        genre.setName(name);

        service.save(genre);
        return ResponseEntity.ok(GenreMapper.MAPPER.genreToGenreDto(genre));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(GenreNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestParam("name") String name) {
        try {
            service.update(id, name);
            return ResponseEntity.ok().build();
        } catch (GenreNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public GenreDto getAuthorById(@PathVariable("id") Long id) {
        try {
            return service.getById(id);
        } catch (GenreNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found" , e);
        }
    }

    @GetMapping("all")
    public List<GenreDto> getAll() {
        try {
            return service.getAll();
        } catch (Exception e) {
            return null;
        }
    }

}
