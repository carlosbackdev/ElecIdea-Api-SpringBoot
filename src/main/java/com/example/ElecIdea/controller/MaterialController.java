package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.Material;
import com.example.ElecIdea.service.MaterialService;
import com.example.ElecIdea.utils.ResponseMessage;
import com.example.ElecIdea.utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/materials")
@CrossOrigin(origins = "*")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    
    @GetMapping("/{nif}/costs")
    public ResponseEntity<String> getTotalCostForMonth(@PathVariable String nif) {
        try {
            String totalCost = materialService.getTotalCostForMonth(nif);
            if (totalCost != null) {
                return ResponseEntity.ok(totalCost);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron facturas pagadas para el mes actual.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Esto mostrará el stack trace completo
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al obtener los gastos.");
        }
    }
}
