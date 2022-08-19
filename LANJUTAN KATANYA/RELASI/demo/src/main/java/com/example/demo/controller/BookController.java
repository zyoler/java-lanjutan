package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    List<Book> book = null;
    BookDto bookDto = new BookDto();
    Book result = null;


    @RequestMapping(value = "/insertBook", method = RequestMethod.GET)
    public String doInsertBook(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("bookDto",bookDto);
        return "insertBook";
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String saveBook(BookDto bookDto, ModelMap modelMap) throws Exception{
        result = bookService.insertBook(bookDto);
        return "redirect:/insertBook";
    }

}
