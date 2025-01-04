
package com.example.ElecIdea.repositories;

import com.example.ElecIdea.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    List<Project> findTop5ByNifOrderByDateDesc(String nif);
}
