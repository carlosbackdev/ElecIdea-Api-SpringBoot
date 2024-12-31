package com.example.ElecIdea.service;

import com.example.ElecIdea.model.Company;
import com.example.ElecIdea.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public String registerCompany(Company company) {
        if (companyRepository.existsByPhone(company.getPhone())) {
            return "El teléfono ya está registrado";
        }
        if (companyRepository.existsByPhone(company.getName())) {
            return "El nombres ya está registrado";
        }
        if (companyRepository.existsByPhone(company.getPhone())) {
            return "El teléfono ya está registrado";
        }
        
        if (companyRepository.existsByEmail(company.getEmail())) {
            return "El correo electrónico ya está registrado";
        }
        companyRepository.save(company);
        return "Empresa registrada con éxito";
    }
}
