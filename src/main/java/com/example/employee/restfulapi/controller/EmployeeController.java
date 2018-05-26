package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.service.EmployeeInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    //在此处完成Employee API
  @Autowired
  private EmployeeInterface employeeService;

  @GetMapping
  List<Employee> getEmployees() {
    return employeeService.getEmployeeList();
  }

  @GetMapping("{employeeId}")
  Employee getEmployee(@PathVariable long employeeId) {
    return employeeService.getEmployeeById(employeeId);
  }

  @GetMapping("page/{page}/pageSize/{pageSize}")
  Page<Employee> getEmployeeByPageAndPageSize(@PathVariable int page, @PathVariable int pageSize) {
    return employeeService.getEmployeeListByPageAndPageSize(new PageRequest(page, pageSize));
  }


}
