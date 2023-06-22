package com.example.Employeems.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "employee")
public class EmployeeDTO {

    private int empID;
    private String empName;
    private String empAddress;
    private String empMobileNumber;
}
