

package com.example.ElecIdea.repositories;


import com.example.ElecIdea.model.Material;
import com.example.ElecIdea.repositories.MaterialRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, String>{
List<Material> findByNifAndDateContaining(String nif, String date);
}
