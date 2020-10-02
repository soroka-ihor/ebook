package com.elib.author;

import com.elib.author.dto.AuthorDto;
import com.elib.author.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDto getById(Long id) {
        return authorRepository.findById(id)
                .map(AuthorMapper.MAPPER::authorToAuthorDto)
                .orElseThrow(NullPointerException::new);
    }

    public AuthorDto getByName(String name) {
        return authorRepository.findByName(name)
                .map(AuthorMapper.MAPPER::authorToAuthorDto)
                .orElseThrow(NullPointerException::new);
    }

    public List<AuthorDto> getAuthors() {
        return StreamSupport.stream(authorRepository.findAll().spliterator(), true)
                .map(author -> AuthorMapper.MAPPER.authorToAuthorDto(author))
                .collect(Collectors.toList());
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

}
