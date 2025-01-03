

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
import java.util.Optional;

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
    user.setPassword(contraseña.encryptPassword(user.getPassword()));
    userRepository.save(user);
    ResponseMessage responseMessage = new ResponseMessage("success", "Usuario registrado con éxito.");
    return responseMessage;
    }
    
    public User validateUser(String usuario, String password) {
    User user = userRepository.findByUsuario(usuario).orElse(null);
        if (user != null && user.getPassword().equals(contraseña.encryptPassword(password))) {
            return user;
        }
        return null;
    }
    public Optional<User> findById(String userId) {
        return userRepository.findById(userId);
    }       
}
    
