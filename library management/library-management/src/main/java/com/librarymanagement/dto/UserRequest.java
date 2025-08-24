package com.librarymanagement.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRequest {

    private Integer userId;

    private String name;

    private String userName;

    private String password;

    private Integer roleId;

    List<BorrowRequest> Borrows = new ArrayList<>();

}
