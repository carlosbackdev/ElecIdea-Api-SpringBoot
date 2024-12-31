
package com.example.ElecIdea.repositories;

import com.example.ElecIdea.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByName(String phone);
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
}
