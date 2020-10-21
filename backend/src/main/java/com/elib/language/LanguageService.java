package com.elib.language;

import com.elib.exception.LanguageNotFoundException;
import com.elib.language.dto.LanguageDto;
import com.elib.language.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public LanguageDto findById(Long id) {
        return languageRepository.findById(id)
                .map(LanguageMapper.MAPPER::languageToLanguageDto)
                .orElseThrow(LanguageNotFoundException::new);
    }

    public void save(Language language) {
        languageRepository.save(language);
    }

    public void deleteById(Long id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
        } else {
            throw new LanguageNotFoundException();
        }
    }

    public List<LanguageDto> getAll() {
        return StreamSupport.stream(languageRepository.findAll().spliterator(), true)
                .map(language -> LanguageMapper.MAPPER.languageToLanguageDto(language))
                .collect(Collectors.toList());
    }
}
