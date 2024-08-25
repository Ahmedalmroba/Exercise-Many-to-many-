package com.example.jparelation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.lang.NonNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Address {

    @Id
    private Integer Id;

    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String street;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(23) not null")
    private String buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}



