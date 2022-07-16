package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Company;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {
    private CompanyRepository companyRepository;

    public Company findCompanyById(Long id) {
        return companyRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public void saveCompanyById(Long id) {
        companyRepository.save(findCompanyById(id));
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }
}
