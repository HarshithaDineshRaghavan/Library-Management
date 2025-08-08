package com.librarymanagement.library.management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name="user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Id
    private Integer roleId;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private List<Borrows> borrows = new ArrayList<>();

}
