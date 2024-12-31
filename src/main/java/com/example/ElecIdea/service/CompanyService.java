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
         System.out.println("Verificando si el nombre ya está registrado: " + company.getName());
        
        if (companyRepository.existsByName(company.getName())) {
            return "El nombres ya está registrado";
        }
        System.out.println("Verificando si el email ya está registrado: " + company.getEmail());
         if (companyRepository.existsByEmail(company.getEmail())) {
            return "El correo electrónico ya está registrado";
        }
         System.out.println("Verificando si el teléfono ya está registrado: " + company.getPhone());
         if (companyRepository.existsByPhone(company.getPhone())) {
            return "El teléfono ya está registrado";
        }       
        companyRepository.save(company);
        return "Empresa registrada con éxito";
    }
}
