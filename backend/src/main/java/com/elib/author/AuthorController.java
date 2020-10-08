package com.elib.author;

import com.elib.author.dto.AuthorDto;
import com.elib.author.model.Author;
import com.elib.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> save (@RequestParam("name") String name) {
        Author author = new Author();
        author.setName(name);

        authorService.save(author);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            authorService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestParam("name") String name) {
        try {
            authorService.update(id, name);
            return ResponseEntity.ok().build();
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        try {
            return authorService.getById(id);
        } catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author with id " + id + " not found.", e);
        }
    }

    @GetMapping("all")
    public List<AuthorDto> getAll() {
        try {
           return authorService.getAuthors();
        } catch (Exception e) {
           return null;
        }
    }
}
