package com.elib.cover;

import com.elib.cover.dto.CoverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverService {

    @Autowired
    CoverRepository coverRepository;

    public CoverDto getById(Long id) {
        CoverDto coverDto = coverRepository.findById(id)
                .map(CoverMapper.MAPPER::coverToCoverDto).orElseThrow(NullPointerException::new);
        return coverDto;
    }

    public void saveCover(CoverDto coverDto) {
        coverRepository.save(CoverMapper.MAPPER.coverDtoToSave(coverDto));
    }

}
