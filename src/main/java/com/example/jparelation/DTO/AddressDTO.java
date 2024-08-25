package com.example.jparelation.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
private Integer teacherId;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String street;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(23) not null")
    private String buildingNumber;
}
