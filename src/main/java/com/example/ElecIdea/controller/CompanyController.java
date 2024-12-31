
package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.Company;
import com.example.ElecIdea.repositories.CompanyRepository;
import com.example.ElecIdea.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCompany(@RequestBody Company company) {
         System.out.println("Datos recibidos: " + company.getName() + ", " + company.getNif() + ", " + company.getEmail() + ", " + company.getPhone());
        if (company.getName() == null || company.getNif() == null || company.getEmail() == null || company.getIban() == null) {
            return ResponseEntity.badRequest().body("Por favor, rellena todos los campos obligatorios.");
        }

         String result = companyService.registerCompany(company);

        // Devolver la respuesta adecuada según el resultado
        if (result.equals("Empresa registrada con éxito")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}