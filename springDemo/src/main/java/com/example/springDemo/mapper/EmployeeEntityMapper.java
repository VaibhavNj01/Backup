package com.example.springDemo.mapper;

import com.example.springDemo.entity.EmployeeEntity;
import com.example.springDemo.model.Employee;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public class EmployeeEntityMapper {


        @org.mapstruct.Mapping(target = "firstName", source = "employeeEntity.firstName")
        @org.mapstruct.Mapping(target = "lastName", source = "employeeEntity.lasName")
        Employee entityToEmp(EmployeeEntity employeeEntity) {
                return null;
        }
}
