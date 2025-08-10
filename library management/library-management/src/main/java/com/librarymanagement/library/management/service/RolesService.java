package com.librarymanagement.library.management.service;

import com.librarymanagement.library.management.entity.Roles;
import com.librarymanagement.library.management.repository.RolesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Optional<Roles> getRoleById(Integer id) {
        return rolesRepository.findById(id);
    }
}

