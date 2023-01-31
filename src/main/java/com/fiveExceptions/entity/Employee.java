package com.fiveExceptions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @OneToOne
    private Department department;
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean status;
}
