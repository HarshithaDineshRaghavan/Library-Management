package com.librarymanagement.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BorrowRequest {

    private Integer borrowId;

    private Integer userId;

    private String borrowDate;

    private String dueDate;

    private String returnDate;

    private Boolean isReturned;



}
