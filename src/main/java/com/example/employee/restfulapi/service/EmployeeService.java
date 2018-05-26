package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeInterface{

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getEmployeeList() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeById(long id) {
    return employeeRepository.findById(id);
  }

  @Override
  public Page<Employee> getEmployeeListByPageAndPageSize(Pageable pageable) {
    return employeeRepository.findAll(pageable);
  }
}
