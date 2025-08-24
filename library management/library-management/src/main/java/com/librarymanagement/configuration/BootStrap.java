package com.librarymanagement.configuration;

import com.librarymanagement.entity.Roles;
import com.librarymanagement.entity.Users;
import com.librarymanagement.repository.RolesRepository;
import com.librarymanagement.repository.UsersRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
public class BootStrap {

    private static final List<String> roles = Arrays.asList("user","admin");
    private final static String adminUsername = "admin@123.com";
    private final static String adminpassword = "123";

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;


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

    @PostConstruct
    @Transactional
    //create default admin user
    public void createDefaultAdmin() {
        Users admin = usersRepository.findByUserName(adminUsername).orElse(null);
        if (admin == null) {
            System.out.println("BootStrap.createDefaultAdmin");
            admin = new Users();
            admin.setUserName(adminUsername);

            admin.setPassword(passwordEncoder.encode(adminpassword));
            Roles role = rolesRepository.findFirstByRole("admin");
            admin.setRoles(Set.of(role));
            usersRepository.save(admin);
            System.out.println("default admin Created");
        }else {
            System.out.println("admin already created");
        }
    }


}
