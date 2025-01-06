package com.example.ElecIdea.service;

import com.example.ElecIdea.model.Company;
import com.example.ElecIdea.repositories.CompanyRepository;
import com.example.ElecIdea.utils.contraseña;
import com.example.ElecIdea.utils.PasswordGenerate;
import com.example.ElecIdea.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;
import org.springframework.mail.javamail.JavaMailSender;
import com.example.ElecIdea.utils.ResponseMessage;
import java.util.*;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    
    @Autowired
    private EmailService emailService;

    public ResponseMessage registerCompany(Company company) {   
        if (companyRepository.existsByName(company.getName())) {
            return new ResponseMessage("error", "El nombre ya está registrado");
        }
         if (companyRepository.existsByEmail(company.getEmail())) {
            return new ResponseMessage("error", "El correo electrónico ya está registrado");
        }
         if (companyRepository.existsByPhone(company.getPhone())) {
            return new ResponseMessage("error", "El teléfono ya está registrado");
        }
         if (companyRepository.existsByNif(company.getNif())) {
            return new ResponseMessage("error", "El NIF ya está registrado");
        }
        String codigo = PasswordGenerate.generarContrasena(14);
        String codigoEncriptado = contraseña.encryptPassword(codigo);
        
        ResponseMessage responseMessage = new ResponseMessage("success", "Empresa registrada con éxito.\n\nEn tu correo recibirás el código de alta de usuarios.");

            new Thread(() -> {
            try {
                emailService.enviarCorreo(company.getEmail(), "<p>Código de Registro", "Estimado/a "+company.getName()+",</p>"
                        + "<p>Nos complace informarle que su empresa ha sido registrada con éxito en nuestro sistema.</p><p>Para proceder con el registro de usuarios adicionales de su empresa,</p>"
                        + "<p>solicitamos que utilice el siguiente código y lo conserve en un lugar seguro: " + codigo + "</p>"
                        + "<p>Agradecemos su confianza en nuestros servicios.</p><p>Atentamente,[ElecIdea]</p>");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }).start();
            
            company.setCode(codigoEncriptado);
            companyRepository.save(company);
        return responseMessage;
            
        }
        //cliente 
        public Optional<Company> getCompanyByNif(String nif) {
            return companyRepository.findById(nif);
        }
}

