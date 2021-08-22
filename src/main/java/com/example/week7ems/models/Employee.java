package com.example.week7ems.models;

import com.example.week7ems.enums.Title;
import com.example.week7ems.enums.Department;
import com.example.week7ems.enums.Qualification;
import com.example.week7ems.enums.Position;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_Id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Title title;

    private String name;
    private String email;

    @Column(nullable = true)
    private String password;

    private String address;
    private String maritalStatus;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Qualification qualification;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private Position position;
}
