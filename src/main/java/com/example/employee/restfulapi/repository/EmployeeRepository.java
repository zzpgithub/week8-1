package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Employee;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  Employee findById(Long id);

  List<Employee> findByGender(String gender);
}
