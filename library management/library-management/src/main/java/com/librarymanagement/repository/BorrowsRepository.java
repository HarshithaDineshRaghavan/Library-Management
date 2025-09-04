package com.librarymanagement.repository;

import com.librarymanagement.entity.Borrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowsRepository extends JpaRepository<Borrows, Integer> {
}
