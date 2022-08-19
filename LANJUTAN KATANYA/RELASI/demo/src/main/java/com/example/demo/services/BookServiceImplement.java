package com.example.demo.services;

import com.example.demo.dto.BookDto;
import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplement implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book insertBook(BookDto bookDto){
        Book model = new Book();
        Book result = new Book();
        try {
            model.setIsbn(bookDto.getIsbn());
            model.setRating(bookDto.getRating());
            model.setTitle(bookDto.getTitle());
            model.setPublished_date(bookDto.getPublished_date());
            model.setTotal_pages(bookDto.getTotal_pages());
            //model.setPhoto(bookDto.getPhoto_id());

            result = bookRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }
}
