
package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.Company;
import com.example.ElecIdea.repositories.CompanyRepository;
import com.example.ElecIdea.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ElecIdea.utils.ResponseMessage;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> registerCompany(@RequestBody Company company) {
       
        if (company.getName() == null || company.getNif() == null || company.getEmail() == null || company.getPostal() == null || company.getCity() == null || company.getPhone() == null) {
            return ResponseEntity.badRequest().body(new ResponseMessage("error", "Por favor, rellena todos los campos obligatorios."));
        }

        ResponseMessage result = companyService.registerCompany(company);

        if (result.equals("Empresa registrada con éxito")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}