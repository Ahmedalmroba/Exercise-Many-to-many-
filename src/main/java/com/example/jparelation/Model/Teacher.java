package com.example.jparelation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Column(columnDefinition = "int not null")
    private int age;
    @Email
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;
    @Column(columnDefinition = "int not null")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany
   private Set<Course> courses;
}
