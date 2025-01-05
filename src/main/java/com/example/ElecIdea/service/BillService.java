

package com.example.ElecIdea.service;

import com.example.ElecIdea.model.Bill;
import com.example.ElecIdea.model.Client;
import com.example.ElecIdea.repositories.BillRepository;
import com.example.ElecIdea.repositories.ClientRepository;
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
public class BillService {
    
    @Autowired
    private BillRepository billRepository;
      
    @Autowired
    private ClientRepository clientRepository;
       
    @Autowired
    private EmailService emailService;
   
    public List<Bill> getBillsByNifAndStatus(String nif) {
        return billRepository.findByNifAndStatusInOrderByDateAsc(nif,Arrays.asList("sin enviar", "pendiente pago"));
    }
    
     public List<Bill> searchBillsByName(String nif, String name) {
        return billRepository.findByNifAndNameContainingIgnoreCaseAndStatusIn(nif, name,Arrays.asList("sin enviar", "pendiente pago"));
    }
     
    public String getTotalPaidBillsForMonth(String nif) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
        String monthYear = sdf.format(calendar.getTime()); 

         List<Bill> bills = billRepository.findByNifAndStatusAndDateContaining(nif, "pagado", monthYear);
        double total = bills.stream().mapToDouble(bill -> Double.parseDouble(bill.getTotal())).sum();

        return String.format("%.2f", total); 
    }

     
     public void sendBill(String billId, String billCode) {
        Bill bill = billRepository.findByCode(billCode)
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada con ID: " + billCode));

        Client client = clientRepository.findById(billId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + billId));

        new Thread(() -> {
            try {
                String subject = "Factura pendiente: " + billCode;
                String message = "<p>Estimado/a " + client.getName() + ",</p>"
                        + "<p>Le informamos que su factura con código <strong>" + billCode + "</strong> está pendiente.</p>"
                        + "<p>Por favor, acceda al siguiente enlace para pagarla:http....</p>"
                        + "<p>Saludos cordiales,</p><p>El equipo de ElecIdea</p>";

                emailService.enviarCorreo(client.getEmail(), subject, message);//igual tengo que añadir otro argumento aunque sea vacio
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }).start();
        bill.setStatus("pendiente pago");
        billRepository.save(bill);
    }
}
