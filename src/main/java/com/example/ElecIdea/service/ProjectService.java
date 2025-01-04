
package com.example.ElecIdea.service;

import com.example.ElecIdea.model.Project;
import com.example.ElecIdea.repositories.ProjectRepository;
import com.example.ElecIdea.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
   
    public List<Project> getRecentProjectByNif(String nif) {
        return projectRepository.findTop5ByNifOrderByDateDesc(nif);
    }
    
    public List<Project> searchProjectByName(String nif, String name) {
        return projectRepository.findByNifAndNameContainingIgnoreCase(nif, name);
    } 
    
}