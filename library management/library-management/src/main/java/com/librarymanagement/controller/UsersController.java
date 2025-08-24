package com.librarymanagement.controller;

import com.librarymanagement.dto.UserRequest;
import com.librarymanagement.entity.Users;
import com.librarymanagement.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user/")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/addUser")
    public String getAddUserPage(){
        System.out.println("UsersController.getAddUserPage");
        return "add-user";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute  UserRequest userRequest){
        usersService.saveUser(userRequest);
        return "home";
    }
}


