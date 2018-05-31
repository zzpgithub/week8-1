package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import com.example.employee.restfulapi.service.CompanyInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

  //在此处完成Company API
  @Autowired
  private CompanyInterface companyService;

  @GetMapping
  List<Company> getCompanies() {
    return companyService.getCompanyList();
  }

  @GetMapping("{companyId}")
  Company getCompany(@PathVariable long companyId) {
    return companyService.getCompanyById(companyId);
  }

  @GetMapping("{companyId}/employees")
  List<Employee> getEmployeesByCompanyId(@PathVariable long companyId) {
    return companyService.getEmployeesByCompanyId(companyId);
  }

  @GetMapping("page/{pageNumber}/pageSize/{pageSizeNumber}")
  Page<Company> getCompaniesByPage(@PathVariable int pageNumber, @PathVariable int pageSizeNumber) {
    return companyService.getCompaniesByPageAndPageSize(new PageRequest(pageNumber, pageSizeNumber));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Company saveCompany(@RequestBody Company company) {
    return companyService.saveCompany(company);
  }

  @PutMapping("{companyId}")
  Company updateCompany(@PathVariable long companyId, @RequestBody Company company) {
    return companyService.updateCompanyById(companyId, company);
  }

  @DeleteMapping("{companyId}")
  String deleteCompany(@PathVariable long companyId) {
    return companyService.deleteCompanyById(companyId);
  }
}
