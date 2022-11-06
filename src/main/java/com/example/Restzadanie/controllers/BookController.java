package com.example.Restzadanie.controllers;


import com.example.Restzadanie.models.Book;
import com.example.Restzadanie.models.BookDto;
import com.example.Restzadanie.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("books")

public class BookController {

    private final BookService bookService;

    @GetMapping
    List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<Book> get(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    @PostMapping
    ResponseEntity<Book> create(@RequestBody BookDto bookDto) {
        Book book = bookService.create(bookDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(book);
    }

    @PutMapping("{id}")
    ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.update(id, bookDto));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();

    }

}