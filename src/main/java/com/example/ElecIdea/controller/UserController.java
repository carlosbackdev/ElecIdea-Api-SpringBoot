

package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.User;
import com.example.ElecIdea.repositories.UserRepository;
import com.example.ElecIdea.service.UserService;
import com.example.ElecIdea.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> registerUser(@RequestBody User user,@RequestParam String companyCode) {
       
        if (user.getUsuario() == null || user.getName() == null || user.getPassword() == null) {
        return ResponseEntity.badRequest().body(new ResponseMessage("error", "Por favor, rellena todos los campos obligatorios."));
        }

        ResponseMessage result = userService.registerUser(user, companyCode);

        if ("success".equals(result.getStatus())) { 
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

}
