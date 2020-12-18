package com.elib.cover;

import com.elib.cover.dto.CoverDto;
import com.elib.cover.model.Cover;
import com.elib.storage.files.FilesStorageService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/cover")
@CrossOrigin("http://localhost:3000")
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

    @GetMapping(value = "{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getCover(@PathVariable Long id) throws IOException {
        InputStream is = new FileInputStream(storageService.downloadCover(coverService.getById(id).getFileName()).getFile());
        return IOUtils.toByteArray(is);
    }

}
