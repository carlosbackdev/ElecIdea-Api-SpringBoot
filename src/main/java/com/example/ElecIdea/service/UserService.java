

package com.example.ElecIdea.service;

import com.example.ElecIdea.model.User;
import com.example.ElecIdea.model.Company;
import com.example.ElecIdea.repositories.UserRepository;
import com.example.ElecIdea.repositories.CompanyRepository;
import com.example.ElecIdea.utils.contraseña;
import com.example.ElecIdea.utils.PasswordGenerate;
import com.example.ElecIdea.utils.IDgenerador;
import com.example.ElecIdea.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ElecIdea.utils.contraseña;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CompanyRepository companyRepository;
    
    public ResponseMessage registerUser(User user,String companyCode){
        
        if(userRepository.existsByUsuario(user.getUsuario())){
             return new ResponseMessage ("error", "El nombre ya está registrado");
        }
    
    Company company = companyRepository.findByCode(contraseña.encryptPassword(companyCode));
        if (company == null) {
            return new ResponseMessage ("error","El código de empresa no es válido.");
        }
        
    int idInt =IDgenerador.generadorId();
    String id = String.valueOf(idInt);
    
    user.setNif(company.getNif());
    user.setUser("usuario");
    user.setId(id);
    userRepository.save(user);
    ResponseMessage responseMessage = new ResponseMessage("success", "Empresa registrada con éxito.\n\nEn tu correo recibirás el código de alta de usuarios.");
    return responseMessage;
    }
}
    
