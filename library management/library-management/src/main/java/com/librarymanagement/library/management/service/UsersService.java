package com.librarymanagement.library.management.service;

import com.librarymanagement.library.management.entity.Users;
import com.librarymanagement.library.management.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<Users> getUserById(Integer id) {
        return usersRepository.findById(id);
    }
}


