package com.example.Restzadanie.repositories;

import com.example.Restzadanie.models.Book;
import com.example.Restzadanie.models.BookDto;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    static Long currentId = 5L;

    private final List<Book> books = new LinkedList<>(Arrays.asList(
            new Book(1L, "Pułapki myślenia. O myśleniu szybkim i wolnym", "Kahneman Daniel", 2012),
            new Book(2L, "Czarny telefon ", "Hill Joe", 2021),
            new Book(3L, "Drood", "Simmons Dan", 2022),
            new Book(4L, "Mężczyzna, który uderzy dziecko ", "Kotarski Radosław", 2023)
    ));


    public List<Book> getAll() {
        return books;
    }

    public Optional<Book> get(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public Book create(BookDto bookDto) {
        Book newBook = new Book(currentId++, bookDto);
        books.add(newBook);
        return newBook;
    }

    public Book update(Book book, BookDto bookDto) {

        book.setAuthor(bookDto.getAuthor());

        return book;
    }

    public void delete(Book book) {
        books.remove(book);
    }
}
