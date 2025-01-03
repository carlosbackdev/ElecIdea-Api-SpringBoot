
package com.example.ElecIdea.repositories;

import com.example.ElecIdea.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    boolean existsByUsuario(String usuario);
    Optional<User> findByUsuario(String usuario);
    Optional<User> findById(String userId);
}
