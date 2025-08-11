package com.librarymanagement.library.management.service;

import com.librarymanagement.library.management.entity.Authors;
import com.librarymanagement.library.management.repository.AuthorsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Optional<Authors> getAuthorById(Integer id) {
        return authorsRepository.findById(id);
    }
}
