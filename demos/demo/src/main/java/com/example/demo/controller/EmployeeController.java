package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.crossasyst.demo.EmployeeService;
import com.example.demo.service.EmployeeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {

        Employee emp = employeeService.getEmployee(1L);

        return new ResponseEntity<>(emp, HttpStatus.OK);

    }

    @PostMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee) {

        EmployeeResponse employeeResponse = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);

    }

    @PutMapping(path = "/employees/{employeeId}")
    public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Long employeeId){

        Employee emp = employeeService
    }

}