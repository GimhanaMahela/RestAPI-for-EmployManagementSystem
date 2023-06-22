package com.example.Employeems.repository;

import com.example.Employeems.entity.Employee;
import  org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
