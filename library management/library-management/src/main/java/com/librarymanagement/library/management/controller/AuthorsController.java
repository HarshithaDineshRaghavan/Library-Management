package com.librarymanagement.library.management.controller;

import com.librarymanagement.library.management.entity.Authors;
import com.librarymanagement.library.management.service.AuthorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable Integer id) {
        return authorsService.getAuthorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


