package com.elib.author;

import com.elib.author.dto.AuthorDto;
import com.elib.author.model.Author;
import com.elib.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDto getById(Long id) {
        return authorRepository.findById(id)
                .map(AuthorMapper.MAPPER::authorToAuthorDto)
                .orElseThrow(AuthorNotFoundException::new);
    }

    public AuthorDto getByName(String name) {
        return authorRepository.findByName(name)
                .map(AuthorMapper.MAPPER::authorToAuthorDto)
                .orElseThrow(AuthorNotFoundException::new);
    }

    public List<AuthorDto> getAuthors() {
        return StreamSupport.stream(authorRepository.findAll().spliterator(), true)
                .map(author -> AuthorMapper.MAPPER.authorToAuthorDto(author))
                .collect(Collectors.toList());
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void update(Long id, String name) {
        Author author = authorRepository.findById(id)
                .orElseThrow(AuthorNotFoundException::new);
        authorRepository.updateName(id, name);
    }

    public void deleteById(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        } else {
            throw new AuthorNotFoundException();
        }
    }

}
