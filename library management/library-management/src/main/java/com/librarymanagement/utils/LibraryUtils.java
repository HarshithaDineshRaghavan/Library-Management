package com.librarymanagement.utils;

import com.librarymanagement.dto.UserRequest;
import com.librarymanagement.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Pattern;


@Configuration
public class LibraryUtils {

    Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

    @Autowired
    PasswordEncoder passwordEncoder;


    public  Users mapDtoEntity(UserRequest userRequest) {
        Users users = new Users();
        if (!BCRYPT_PATTERN.matcher(userRequest.getPassword()).matches()) {
            users.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        }
        users.setUserName(userRequest.getUserName());
        users.setName(userRequest.getName());
        return users;
    }


}
