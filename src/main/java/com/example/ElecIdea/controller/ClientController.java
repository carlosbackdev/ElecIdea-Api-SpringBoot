
package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.Client;
import com.example.ElecIdea.service.ClientService;
import com.example.ElecIdea.utils.ResponseMessage;
import com.example.ElecIdea.utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import java.util.*;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/{nif}/recent")
    public ResponseEntity<List<Client>> getRecentClientsByNif(@PathVariable String nif) {
        List<Client> recentClients = clientService.getRecentClientsByNif(nif);
        if (recentClients != null && !recentClients.isEmpty()) {
            return ResponseEntity.ok(recentClients);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }

    @GetMapping("/{nif}/search")
    public ResponseEntity<List<Client>> searchClientsByName(@PathVariable String nif, @RequestParam String name) {
        List<Client> clients = clientService.searchClientsByName(nif, name);
        if (clients != null && !clients.isEmpty()) {
            return ResponseEntity.ok(clients);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }
}
