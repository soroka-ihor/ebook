package com.elib.book;

import com.elib.book.dto.BookDto;
import com.elib.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks(Pageable page) {
        List<Book> books;
        Page<Book> pageOfBooks = bookRepository.findAll(page);
        books = pageOfBooks.getContent();

        return StreamSupport.stream(books.spliterator(), true)
                .map(book -> BookMapper.MAPPER.bookToBookDto(book))
                .collect(Collectors.toList());
    }

    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper.MAPPER::bookToBookDto)
                .orElseThrow(NullPointerException::new);
    }

}
