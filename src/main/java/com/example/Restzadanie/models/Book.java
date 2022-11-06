package com.example.Restzadanie.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private Integer year;

    public Book(Long id, BookDto bookDto) {
        this.id = id;
        this.title = bookDto.getTitle();
        this.author = bookDto.getAuthor();
        this.year = bookDto.getYear();}
}
