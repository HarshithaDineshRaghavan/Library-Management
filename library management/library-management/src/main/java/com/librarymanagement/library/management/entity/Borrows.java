package com.librarymanagement.library.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="borrows")
public class Borrows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name = "borrow_date")
    private String borrowDate;

    @Column(name="due_date")
    private String dueDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "is_returned")
    private Boolean isReturned;
}
