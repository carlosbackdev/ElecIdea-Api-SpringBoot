package com.example.ElecIdea.controller;

import com.example.ElecIdea.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String sendEmail(@RequestParam String nombre, @RequestParam String email, @RequestParam String mensaje) {
        try {
            String subject = "Nuevo mensaje de contacto de " + nombre;
            String body = "Nombre: " + nombre + "\nCorreo: " + email + "\nMensaje: " + mensaje;
            emailService.enviarCorreo("carlosbackdev@gmail.com", subject, body);
            return "Mensaje enviado con éxito!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Hubo un error al enviar el mensaje.";
        }
    }
}
