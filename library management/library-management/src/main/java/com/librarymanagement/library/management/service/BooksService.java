package com.librarymanagement.library.management.service;

import com.librarymanagement.library.management.entity.Books;
import com.librarymanagement.library.management.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Optional<Books> getBookById(Integer id) {
        return booksRepository.findById(id);
    }
}


