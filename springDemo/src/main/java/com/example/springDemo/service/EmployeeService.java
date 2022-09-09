package com.example.springDemo.service;

import com.example.springDemo.entity.EmployeeEntity;
import com.example.springDemo.model.Employee;
import com.example.springDemo.model.EmployeeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Service
@Log4j2
public class EmployeeService {


    private List<EmployeeEntity> employeeEntityList;
    EmployeeEntity employeeEntity;

    public EmployeeService() {
//        employeeEntityList = List.of(
//                new EmployeeEntity(101L, "Kunal", "Dinkar"),
//                new EmployeeEntity(102L, "Uttam", "Thakare"),
//                new EmployeeEntity(103L, "vaibhav", "jadhav"),
//                new EmployeeEntity(104L, "yash", "goyal"),
//                new EmployeeEntity(105L, "suchit", "khadtar")
//        );
           employeeEntityList = new ArrayList<>();
        employeeEntityList.add(new EmployeeEntity(1L, "Kunal", "Dinkar"));
        employeeEntityList.add(new EmployeeEntity(2L, "Prem", "Patil"));
        employeeEntityList.add(new EmployeeEntity(3L, "Uttam", "Thakre"));
        employeeEntityList.add(new EmployeeEntity(4L, "Vaibhav", "Jadhav"));
        employeeEntityList.add(new EmployeeEntity(5L, "Suchit", "Khadtar"));

    }

    public Employee getEmployee(Long employeeId) {
        Employee employee = new Employee();
        EmployeeEntity ee = null;
        for (EmployeeEntity e : employeeEntityList) {
            if (e.getId() == employeeId) {
                ee = e;
                employee.setFirstName(ee.getFirstName());
                employee.setLastName(ee.getLastName());
                break;
            }

        }
        return employee;

    }

    public EmployeeResponse createEmployee(Employee employee) {
        Long id = new Random().nextLong();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(id);
        log.info("Employee name is :", employee.getFirstName(), employee.getLastName());
        return employeeResponse;
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        for (EmployeeEntity e : employeeEntityList) {
            if (employeeId == e.getId()) {
                e.setFirstName((employee.getFirstName()));
                e.setLastName((employee.getLastName()));
            }

        }
        return employee;
    }

        public void deleteEmployee(Long employeeId) {
            for (EmployeeEntity e : employeeEntityList) {
                if (employeeId == e.getId()) {
                    employeeEntityList.remove(employeeId);
                }
            }
            log.info("Deleted");
        }


}
