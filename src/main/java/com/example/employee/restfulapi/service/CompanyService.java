package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CompanyService implements CompanyInterface{

  @Autowired
  private CompanyRepository companyRepository;

  @Override
  public List<Company> getCompanyList() {
    return companyRepository.findAll();
  }

  @Override
  public Company getCompanyById(long id) {
    return companyRepository.findOne(id);
  }

  @Override
  public List<Employee> getEmployeesByCompanyId(@PathVariable long companyId) {
    Set<Employee> employees = companyRepository.findOne(companyId).getEmployees();
    return new ArrayList<Employee>(employees);
  }

  @Override
  public Page<Company> getCompaniesByPageAndPageSize(Pageable pageable) {
    return companyRepository.findAll(pageable);
  }

  @Override
  public Company saveCompany(Company company) {
    return companyRepository.save(company);
  }

  @Override
  public Company updateCompanyById(long id, Company company) {
    Company updateCompany = companyRepository.findOne(id);

    updateCompany.setCompanyName(company.getCompanyName());
    updateCompany.setEmployeesNumber(company.getEmployeesNumber());

    return companyRepository.save(updateCompany);
  }

  @Override
  public String deleteCompanyById(long companyId) {
    companyRepository.delete(companyId);
    return "delete success";
  }
}
