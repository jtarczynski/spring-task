package com.deloitte.carApp.company.service;

import com.deloitte.carApp.company.entity.Company;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.company.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;

    public Company findCompany(Long id) {
        return companyRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Transactional
    public Company saveCompany(Long id) {
        return companyRepository.save(findCompany(id));
    }

    @Transactional
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
