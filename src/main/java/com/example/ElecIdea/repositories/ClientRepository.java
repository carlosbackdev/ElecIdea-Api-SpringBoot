
package com.example.ElecIdea.repositories;

import com.example.ElecIdea.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    List<Client> findTop5ByNifOrderByDateDesc(String nif);
    List<Client> findByNifAndNameContainingIgnoreCase(String nif, String name);
}
