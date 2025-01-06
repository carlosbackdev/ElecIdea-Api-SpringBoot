
package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.Bill;
import com.example.ElecIdea.service.BillService;
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
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillController {
    
     @Autowired
    private BillService billService;
     
     @GetMapping("/{nif}/all")
    public ResponseEntity<List<Bill>> getBillsByNifAndStatus(@PathVariable String nif) {
        List<Bill> allBills = billService.getBillsByNifAndStatus(nif);
        if (allBills != null && !allBills.isEmpty()) {
            return ResponseEntity.ok(allBills);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }
    
     @GetMapping("/{nif}/search")
    public ResponseEntity<List<Bill>> searchBillsByName(@PathVariable String nif, @RequestParam String name) {
        List<Bill> bills = billService.searchBillsByName(nif, name);
        if (bills != null && !bills.isEmpty()) {
            return ResponseEntity.ok(bills);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }
    
    @GetMapping("/{nif}/gains")
    public ResponseEntity<String> getTotalPaidBillsForMonth(@PathVariable String nif) {
        try {
            String totalPaid = billService.getTotalPaidBillsForMonth(nif);
            if (totalPaid != null) {
                return ResponseEntity.ok(totalPaid);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron facturas pagadas para el mes actual.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al obtener las ganancias.");
        }
    }

    
    @PostMapping("/{billId}/send")
    public ResponseEntity<String> sendBillToClient(
            @PathVariable String billId,
            @RequestParam String billCode) {
        try {
            billService.sendBill(billId, billCode);
            return ResponseEntity.ok("Correo enviado exitosamente al cliente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al enviar el correo.");
        }
    }
    //cliente
    @GetMapping
    public ResponseEntity<?> getBillByCode(@RequestParam("codigo") String code) {
    Optional<Bill> bill = billService.getBillByCode(code);
    if (bill.isPresent()) {
        return ResponseEntity.ok(bill.get());
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Factura no encontrada.");
    }
}
    
}
