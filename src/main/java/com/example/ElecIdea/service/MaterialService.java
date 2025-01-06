package com.example.ElecIdea.service;

import com.example.ElecIdea.model.Material;
import com.example.ElecIdea.repositories.MaterialRepository;
import com.example.ElecIdea.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.ElecIdea.utils.EmailService;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class MaterialService {
    
    @Autowired
    private MaterialRepository materialRepository;
    
    public String getTotalCostForMonth(String nif) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
        String monthYear = sdf.format(calendar.getTime());
        
        List<Material> materials = materialRepository.findByNifAndDateContaining(nif, monthYear);
          if (materials.isEmpty()) {
    }
        double total = materials.stream().mapToDouble(material -> Double.parseDouble(material.getTotal())).sum();
        return String.format("%.2f", total);
    }
}