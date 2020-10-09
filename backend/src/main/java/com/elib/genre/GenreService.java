package com.elib.genre;

import com.elib.exception.GenreNotFoundException;
import com.elib.genre.dto.GenreDto;
import com.elib.genre.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public GenreDto getById(Long id) {
        return genreRepository.findById(id)
                .map(GenreMapper.MAPPER::genreToGenreDto)
                .orElseThrow(GenreNotFoundException::new);
    }

    public GenreDto getByName(String name) {
        return genreRepository.findByName(name)
                .map(GenreMapper.MAPPER::genreToGenreDto)
                .orElseThrow(GenreNotFoundException::new);
    }

    public List<GenreDto> getAll() {
        return StreamSupport.stream(genreRepository.findAll().spliterator(), true)
                .map(genre -> GenreMapper.MAPPER.genreToGenreDto(genre))
                .collect(Collectors.toList());
    }

    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    public void update(Long id, String name) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(GenreNotFoundException::new);
        genreRepository.updateName(id, name);
    }

    public void deleteById(Long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        } else {
            throw new GenreNotFoundException();
        }
    }
}
