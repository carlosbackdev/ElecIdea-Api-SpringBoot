

package com.example.ElecIdea.repositories;

import com.example.ElecIdea.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Client, String> {
    List<Bill> findByNifOrderByDateDesc(String nif);
}

