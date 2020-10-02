package com.elib.cover;

import com.elib.cover.dto.CoverDto;
import com.elib.cover.model.Cover;
import com.elib.storage.files.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8082")
public class CoverController {

    @Autowired
    FilesStorageService storageService;

    @Autowired
    CoverService coverService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) {
        Cover cover = new Cover();
        cover.setName(file.getOriginalFilename());
        try {
            storageService.uploadCover(file);
            coverService.saveCover(cover);
            return ResponseEntity.status(HttpStatus.OK).body("Uploaded the file successfully: " + file.getOriginalFilename());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Couldn't upload file: " + file.getOriginalFilename());
        }
    }

    @GetMapping("/covers")
    public ResponseEntity<List<CoverDto>> getListCovers() {
        return ResponseEntity.status(HttpStatus.OK).body(coverService.getAllCovers());
    }

}
