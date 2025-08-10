package com.librarymanagement.library.management.repository;

import com.librarymanagement.library.management.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
}
