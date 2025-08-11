package com.librarymanagement.library.management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name = "role")
    private String role;

    @OneToMany
    @JoinColumn(name = "role_id")
    private List<Users> users = new ArrayList<>();

}
