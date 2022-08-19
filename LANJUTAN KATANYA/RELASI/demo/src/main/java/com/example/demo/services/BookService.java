package com.example.demo.services;

import com.example.demo.dto.BookDto;
import com.example.demo.models.Book;


public interface BookService {
    public Book insertBook(BookDto bookDto);
}
