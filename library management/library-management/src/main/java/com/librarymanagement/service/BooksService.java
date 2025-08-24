package com.librarymanagement.service;

import com.librarymanagement.entity.Books;
import com.librarymanagement.repository.BooksRepository;
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


