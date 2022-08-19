package org.neophyte.pertemuan1.Repositories;

import org.neophyte.pertemuan1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
