package com.librarymanagement.service;

import com.librarymanagement.dto.UserRequest;
import com.librarymanagement.entity.Roles;
import com.librarymanagement.entity.Users;
import com.librarymanagement.repository.RolesRepository;
import com.librarymanagement.repository.UsersRepository;
import com.librarymanagement.utils.LibraryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    private LibraryUtils libraryUtils;

    @Autowired
    private RolesRepository rolesRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<Users> getUserById(Integer id) {
        return usersRepository.findById(id);
    }

    public Users saveUser(UserRequest userRequest){
        Users user = libraryUtils.mapDtoEntity(userRequest);
        Roles roles = rolesRepository.findFirstByRole("user");
        if(roles != null){
            user.setRoles(Set.of(roles));
        }
        user = usersRepository.save(user);
        return user;
    }
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

    public Users updateUser(Integer id, Users updatedUser) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        user.setName(updatedUser.getName());
        user.setUserName(updatedUser.getUserName());
        user.setPassword(updatedUser.getPassword());
        user.setRoleId(updatedUser.getRoleId());

        return usersRepository.save(user);
    }

}
