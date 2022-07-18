package com.deloitte.carApp.company.controller;

import com.deloitte.carApp.company.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/companies")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;



}
