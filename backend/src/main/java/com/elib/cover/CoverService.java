package com.elib.cover;

import com.elib.cover.dto.CoverDto;
import com.elib.cover.model.Cover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CoverService {

    @Autowired
    CoverRepository coverRepository;

    public CoverDto getById(Long id) {
        CoverDto coverDto = coverRepository.findById(id)
                .map(CoverMapper.MAPPER::coverToCoverDto).orElseThrow(NullPointerException::new);
        return coverDto;
    }

    public void saveCover(Cover cover) {
        coverRepository.save(cover);
    }

    public List<CoverDto> getAllCovers() {
        return StreamSupport.stream(coverRepository.findAll().spliterator(), true).
                map(cover -> CoverMapper.MAPPER.coverToCoverDto(cover))
                .collect(Collectors.toList());
    }
}
