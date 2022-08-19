package org.neophyte.pertemuan1.services;

import lombok.Getter;
import lombok.Setter;
import org.neophyte.pertemuan1.Repositories.BookRepository;
import org.neophyte.pertemuan1.dto.BookDto;
import org.neophyte.pertemuan1.model.Book;
import org.neophyte.pertemuan1.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class BookServiceImplement implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book InsertBook(BookDto bookDto) {
        Book model = new Book();
        Book result = new Book();
        try {
            model.setTitle(bookDto.getTitle());
            model.setIsbn(bookDto.getIsbn());
            model.setTotal_pages(bookDto.getTotal_pages());
            model.setRating(bookDto.getRating());
            model.setPublished_date(bookDto.getPublished_date());
           // model.setPhoto(bookDto.getPhoto());
            result = bookRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }
}
