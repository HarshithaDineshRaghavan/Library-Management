package com.librarymanagement.repository;

import com.librarymanagement.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

     Roles findFirstByRole(String role);
}
