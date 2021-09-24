package com.wypa.employee_manager.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String jobTitles;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;
}
