package com.crossasyst.firstspringproject.controller;

import com.crossasyst.firstspringproject.entity.EmployeeEntity;
import com.crossasyst.firstspringproject.model.Employee;
import com.crossasyst.firstspringproject.model.EmployeeResponse;
import com.crossasyst.firstspringproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping(value = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee){
        EmployeeResponse employeeResponse=employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeResponse,HttpStatus.OK);
    }

//   @PutMapping(path = "/employees/{employeeId}",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
//
//    }
}
