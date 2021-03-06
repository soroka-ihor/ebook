package com.elib.storage.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

    //@Value("${cover.uploads}")
    private String coversUploadPath = "c:/covers/"; // <--- temporary hardcoded. will be corrected

    //@Value("${books.uploads}")
    private String booksUploadPath = "c:/books/"; // <--- temporary hardcoded. will be corrected

    private Path coverUploadsFolder = Paths.get(coversUploadPath);

    private Path bookUploadsFolder = Paths.get(booksUploadPath);

    @Override
    public void init() {
        try {
            Files.createDirectory(coverUploadsFolder);
            Files.createDirectory(bookUploadsFolder);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't initialize folders!");
        }
    }

    @Override
    public void uploadCover(MultipartFile cover) {
        try {
            Files.copy(cover.getInputStream(), coverUploadsFolder.resolve(cover.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Couldn't upload cover! Error: " + e.getMessage());
        }
    }

    @Override
    public Resource downloadCover(String coverFileName) {
        try {
            Path file = coverUploadsFolder.resolve(coverFileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Couldn't read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void uploadBook(MultipartFile book) {
        try {
            Files.copy(book.getInputStream(), bookUploadsFolder.resolve(book.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Couldn't upload book! Error: " + e.getMessage());
        }
    }

    @Override
    public Resource downloadBook(String bookFileName) {
        try {
            Path file = bookUploadsFolder.resolve(bookFileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Couldn't read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
