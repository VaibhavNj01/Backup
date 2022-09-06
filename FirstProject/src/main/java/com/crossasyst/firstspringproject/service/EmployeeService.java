package com.crossasyst.firstspringproject.service;

import com.crossasyst.firstspringproject.entity.EmployeeEntity;
import com.crossasyst.firstspringproject.model.Employee;
import com.crossasyst.firstspringproject.model.EmployeeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@Log4j2

public class EmployeeService {
    private List<EmployeeEntity> employeeEntityList;

    public EmployeeService(){
        employeeEntityList=new ArrayList<>();
        employeeEntityList.add(new EmployeeEntity(1L,"Kunal","Dinkar"));
        employeeEntityList.add(new EmployeeEntity(2L,"Prem","Patil"));
        employeeEntityList.add(new EmployeeEntity(3L,"Uttam","Thakre"));
        employeeEntityList.add(new EmployeeEntity(4L,"Vaibhav","Jadhav"));
        employeeEntityList.add(new EmployeeEntity(5L,"Suchit","Khadtar"));
    }

   /* public Employee getEmployee(Long employeeId) {
        Employee employee = new Employee("Prem", "Patil");
        return employee;
    }*/

    public Employee getEmployee(Long employeeId){
        Employee employee=new Employee();
        EmployeeEntity employeeEntity=null;

        for (EmployeeEntity eE:employeeEntityList) {

                if (eE.getId() == employeeId) {
                    employeeEntity = eE;
                    employee.setFirstName(employeeEntity.getFirstName());
                    employee.setLastName(employeeEntity.getLastName());
                    break;
                }
                else {
                    throw new NullPointerException();
                }
            }
        return employee;
        }

    public EmployeeResponse createEmployee(Employee employee){
        int createId=new Random().nextInt();
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setEmployeeId(createId);
        log.info("Employee Name entered is :"+employee.getFirstName()+" "+employee.getLastName());
        return employeeResponse;

    }

//    public Employee updateEmployee(Employee employee){
//
//
//    }
}
