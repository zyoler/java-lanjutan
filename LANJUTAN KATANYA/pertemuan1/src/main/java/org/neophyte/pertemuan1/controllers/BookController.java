package org.neophyte.pertemuan1.controllers;

import org.neophyte.pertemuan1.dto.BookDto;
import org.neophyte.pertemuan1.dto.MahasiswaDto;
import org.neophyte.pertemuan1.model.Book;
import org.neophyte.pertemuan1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BookController {
    @Autowired
    BookService bookService;
    BookDto bookDto = new BookDto();

    Book result = null;

    @RequestMapping(value = "/InsertBook", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        model.addAttribute("bookDto", bookDto);
        return "insertBook";
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String InsertBook(BookDto bookDto, ModelMap model) throws Exception{
        result = bookService.InsertBook(bookDto);

        return "redirect:/InsertBook";
    }
}
