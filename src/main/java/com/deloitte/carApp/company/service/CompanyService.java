package com.deloitte.carApp.company.service;

import com.deloitte.carApp.company.dto.CompanyDto;
import com.deloitte.carApp.company.entity.Company;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.company.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;

    private ModelMapper modelMapper;

    public Company findCompany(Long id) {
        return companyRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.COMPANY_NOT_FOUND));
    }

    public CompanyDto getCompanyDto(Long id) {
        return modelMapper.map(findCompany(id), CompanyDto.class);
    }

    public List<CompanyDto> findAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public Company saveCompany(CompanyDto companyDto) {
        return companyRepository.save(modelMapper.map(companyDto, Company.class));
    }

    @Transactional
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}