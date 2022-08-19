package org.neophyte.pertemuan1.services;

import org.neophyte.pertemuan1.dto.BookDto;
import org.neophyte.pertemuan1.dto.MahasiswaDto;
import org.neophyte.pertemuan1.model.Book;
import org.neophyte.pertemuan1.model.Mahasiswa;
import org.springframework.stereotype.Service;


public interface BookService {
    public Book InsertBook(BookDto bookDto);
}
