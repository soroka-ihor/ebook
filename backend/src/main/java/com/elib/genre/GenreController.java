package com.elib.genre;

import com.elib.genre.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreRepository repository;

    @GetMapping
    public String add(@RequestParam(name = "add") String genreName) {
        Genre genre = new Genre();
        genre.setName(genreName);
        repository.save(genre);
        return "added";
    }
}
