package com.deloitte.carApp.company.controller;

import com.deloitte.carApp.company.dto.CompanyDto;
import com.deloitte.carApp.company.entity.Company;
import com.deloitte.carApp.company.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("all")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        return ResponseEntity.ok(companyService.findAllCompanies());
    }

    @GetMapping("company-id/{companyId}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable("companyId") Long companyId) {
        return ResponseEntity.ok(companyService.getCompanyDto(companyId));
    }

    @PostMapping("add-company")
    public ResponseEntity<Company> addCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.saveCompany(companyDto));
    }

    @DeleteMapping("delete-company/company-id/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("companyId") Long companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity.accepted().build();
    }

}
