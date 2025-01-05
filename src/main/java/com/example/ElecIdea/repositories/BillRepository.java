

package com.example.ElecIdea.repositories;

import com.example.ElecIdea.model.Bill;
import com.example.ElecIdea.repositories.BillRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public interface BillRepository extends JpaRepository<Bill, String> {
    List<Bill> findByNifAndStatusInOrderByDateAsc(String nif, List<String> status);
    List<Bill> findByNifAndNameContainingIgnoreCaseAndStatusIn(String nif,String name ,List<String> status);
    Optional<Bill> findByCode(String code);   
    List<Bill> findByNifAndStatusAndDateContaining(String nif, String status, String date);
}

