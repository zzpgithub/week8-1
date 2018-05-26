package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Employee;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeInterface {
  List<Employee> getEmployeeList();

  Employee getEmployeeById(long id);

  Page<Employee> getEmployeeListByPageAndPageSize(Pageable pageable);
}
