package com.crossasyst.demo;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@Log4j2
public class EmployeeService {
    private List<EmployeeEntity> employeeEntityList;

    public EmployeeService() {
        employeeEntityList = new ArrayList<>();
        employeeEntityList.add(new EmployeeEntity(1l, "vaibhav", "jadhav"));
        employeeEntityList.add(new EmployeeEntity(2l, "kunal", "dinkar"));
        employeeEntityList.add(new EmployeeEntity(3l, "yash", "goyal"));
        employeeEntityList.add(new EmployeeEntity(4l, "suchit", "khadtar"));
        employeeEntityList.add(new EmployeeEntity(5l, "sanket", "mishra"));

    }

    public Employee getEmployee(Long employeeId) {
        Employee emp = new Employee("kunal", "dinkar");

        return emp;

    }

    public EmployeeResponse createEmployee(Employee employee) {
        int createId = (int) ((Math.random()) * 20);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployeeId(createId);
        log.info("employee name is {} {}", employee.getFirstName(), employee.getLastName());
        return employeeResponse;

    }



//    public EmployeeEntity updateEmployee(Long employeeId) {
//
//
//    }


}
