package com.librarymanagement.library.management.repository;

import com.librarymanagement.library.management.entity.Borrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowsRepository extends JpaRepository<Borrows, Integer> {
}
