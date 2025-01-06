

package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.User;
import com.example.ElecIdea.repositories.UserRepository;
import com.example.ElecIdea.service.UserService;
import com.example.ElecIdea.utils.ResponseMessage;
import com.example.ElecIdea.utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import java.util.Optional;
import com.example.ElecIdea.utils.ChangePasswordRequest;

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
    
        @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody User user, HttpSession session) {
        User existingUser = userService.validateUser(user.getUsuario(), user.getPassword());
        if (existingUser != null) {
            session.setAttribute("user", existingUser);
            LoginResponse response = new LoginResponse("success", "Inicio de sesión exitoso.", existingUser.getId());
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse("error", "Credenciales incorrectas.", null);
            return ResponseEntity.badRequest().body(response);
        }
    }

        @GetMapping("/{userId}/data")
        public ResponseEntity<User> getUserData(@PathVariable String userId) {
            Optional<User> userOptional = userService.findById(userId);
            if (userOptional.isPresent()) {
                return ResponseEntity.ok(userOptional.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }
        
    @PostMapping("/change-password")
    public ResponseEntity<ResponseMessage> changePassword(@RequestBody ChangePasswordRequest request) {
    if (request.getUserId() == null || request.getNewPassword() == null) {
        return ResponseEntity.badRequest().body(new ResponseMessage("error", "Por favor, rellena todos los campos obligatorios."));
    }
    ResponseMessage result = userService.changePassword(request.getUserId(), request.getNewPassword());
    if ("success".equals(result.getStatus())) {
        return ResponseEntity.ok(result);
    } else {
        return ResponseEntity.badRequest().body(result);
    }
}

}
