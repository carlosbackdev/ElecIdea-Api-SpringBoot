
package com.example.ElecIdea.service;

import com.example.ElecIdea.model.Client;
import com.example.ElecIdea.repositories.ClientRepository;
import com.example.ElecIdea.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
   
    public List<Client> getRecentClientsByNif(String nif) {
        return clientRepository.findTop5ByNifOrderByDateDesc(nif);
    }

    public List<Client> searchClientsByName(String nif, String name) {
        return clientRepository.findByNifAndNameContainingIgnoreCase(nif, name);
    }
    public void debugRepository(String nif) {
    List<Client> clients = clientRepository.findTop5ByNifOrderByDateDesc(nif);
    if (clients != null && !clients.isEmpty()) {
        clients.forEach(client -> System.out.println("Cliente: " + client));
    } else {
        System.out.println("No se encontraron clientes para el NIF: " + nif);
    }
}
}