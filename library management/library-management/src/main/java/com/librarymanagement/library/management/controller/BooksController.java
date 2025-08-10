package com.librarymanagement.library.management.controller;

import com.librarymanagement.library.management.entity.Books;
import com.librarymanagement.library.management.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id) {
        return booksService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}



