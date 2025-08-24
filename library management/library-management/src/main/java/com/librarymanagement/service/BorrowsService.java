package com.librarymanagement.service;

import com.librarymanagement.entity.Borrows;
import com.librarymanagement.repository.BorrowsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowsService {

    private final BorrowsRepository borrowsRepository;

    public BorrowsService(BorrowsRepository borrowsRepository) {
        this.borrowsRepository = borrowsRepository;
    }

    public Optional<Borrows> getBorrowById(Integer id) {
        return borrowsRepository.findById(id);
    }
}


