package com.example.Employeems.service;

import com.example.Employeems.dto.EmployeeDTO;
import com.example.Employeems.entity.Employee;
import com.example.Employeems.repository.EmployeeRepository;
import com.example.Employeems.util.varList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO){
        if(employeeRepository.existsById(employeeDTO.getEmpID())){
            return varList.RSP_DUPLICATED;
        }else{
            employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
            return varList.RSP_SUCCESS;
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO){
        if(employeeRepository.existsById(employeeDTO.getEmpID())){
            employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
            return varList.RSP_SUCCESS;
        }
        else {
            return varList.RSP_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<Employee> employeeList = employeeRepository.findAll();
        return modelMapper.map(employeeList,new TypeToken<ArrayList<EmployeeDTO>>(){
        }.getType());
    }

    public EmployeeDTO searchEmployee(int empID){
        if (employeeRepository.existsById(empID)){
            Employee employee = employeeRepository.findById(empID).orElseThrow();
            return modelMapper.map(employee,EmployeeDTO.class);
        }else {
            return null;
        }
    }

    public String deleteEmployee(int empID){
        if (employeeRepository.existsById(empID)){
            employeeRepository.deleteById(empID);
            return varList.RSP_SUCCESS;
        }else {
            return varList.RSP_NO_DATA_FOUND;
        }
    }


}
