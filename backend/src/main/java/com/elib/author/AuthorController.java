package com.elib.author;

import com.elib.author.dto.AuthorDto;
import com.elib.author.model.Author;
import com.elib.exception.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/author/add")
    public ResponseEntity<ResponseMessage> add (@RequestParam("name") String name) {
        Author author = new Author();
        author.setName(name);

        try {
            authorService.save(author);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Author was added successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
        }
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        try {
            return authorService.getById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/author/all/")
    public List<AuthorDto> getAll() {
        try {
           return authorService.getAuthors();
        } catch (Exception e) {
           return null;
        }
    }
}
