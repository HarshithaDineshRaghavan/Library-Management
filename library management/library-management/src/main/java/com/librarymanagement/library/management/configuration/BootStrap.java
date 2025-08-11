package com.librarymanagement.library.management.configuration;

import com.librarymanagement.library.management.entity.Roles;
import com.librarymanagement.library.management.repository.RolesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BootStrap {

    private static final List<String> roles = Arrays.asList("user","admin");

    @Autowired
    private RolesRepository rolesRepository;


    //This will create roles while application bootup
    @PostConstruct
    public void createRoles(){
        roles.forEach(it->{
            Roles role = rolesRepository.findFirstByRole(it);
            if(role == null){
                role = new Roles();
                role.setRole(it);
                rolesRepository.save(role);
            }
        });
    }


}
