package com.example.jparelation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NonNull
    private int age;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")

    private String major;

    @ManyToMany(mappedBy = "student")
    private Set<Course> courses; ;

}
