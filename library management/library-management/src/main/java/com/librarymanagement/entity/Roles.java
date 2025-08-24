package com.librarymanagement.entity;

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



    public Roles(){}

    public Roles(String role, Integer roleId) {
        this.role = role;
        this.roleId = roleId;
    }
}
