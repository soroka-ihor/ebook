package com.elib.language;

import com.elib.exception.LanguageNotFoundException;
import com.elib.language.dto.LanguageDto;
import com.elib.language.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController("/api/language/")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public ResponseEntity<LanguageDto> save(@RequestParam("name") String name) {
        Language language = new Language();
        language.setName(name);

        languageService.save(language);
        return ResponseEntity.ok(LanguageMapper.MAPPER.languageToLanguageDto(language));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            languageService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (LanguageNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public LanguageDto findById(@PathVariable("id") Long id) {
        try {
            return languageService.findById(id);
        } catch (LanguageNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Language with id " + id + " not found.", e);
        }
    }

    @GetMapping("/all")
    public List<LanguageDto> findAll() {
        try {
            return languageService.getAll();
        } catch (Exception e) {
            return null;
        }
    }
}
