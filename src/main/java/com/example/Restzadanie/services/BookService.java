package com.example.Restzadanie.services;

import com.example.Restzadanie.exceptions.ResourceNotFoundException;
import com.example.Restzadanie.models.Book;
import com.example.Restzadanie.models.BookDto;
import com.example.Restzadanie.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository ;

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Book get(Long id) {
        return bookRepository
                .get(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Book create(BookDto bookDto) {
        return bookRepository.create(bookDto);
    }

    public Book update(Long id, BookDto bookDto) {
        Book book = get(id);
        return bookRepository.update(book, bookDto);
    }

    public void delete(Long id) {
        Book book = get(id);
        bookRepository.delete(book);
    }
}
