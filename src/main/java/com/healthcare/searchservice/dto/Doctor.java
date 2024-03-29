package com.healthcare.searchservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Doctor {
    private int id;
    @NotBlank(message = "firstName should not be Empty")
    private String firstName;
    private String lastName;
    private String specialization;
}
