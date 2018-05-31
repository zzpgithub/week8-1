package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyInterface {

  List<Company> getCompanyList();

  Company getCompanyById(long id);

  List<Employee> getEmployeesByCompanyId(long companyId);

  Page<Company> getCompaniesByPageAndPageSize(Pageable pageable);

  Company saveCompany(Company company);

  Company updateCompanyById(long companyId, Company company);

  String deleteCompanyById(long id);
}
