package com.elib.book;

import com.elib.book.dto.BookDto;
import com.elib.book.model.Book;
import com.elib.storage.files.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin("http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private FilesStorageService storage;

    @GetMapping("all")
    public List<BookDto> getAllBooks(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);

        return bookService.getAllBooks(pageable);
    }

    @GetMapping("download")
    public ResponseEntity<InputStreamResource> downloadBook(@RequestParam(name = "id") Long id) throws IOException {
        MediaType mediaType = MediaType.APPLICATION_PDF;

        BookDto book = bookService.getBookById(id);

        File file = storage.downloadBook(book.getContentUrl()).getFile();

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + file.getName())
                .contentType(mediaType)
                .contentLength(file.length())
                .body(resource);
    }

}
