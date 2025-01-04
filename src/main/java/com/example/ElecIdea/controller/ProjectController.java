package com.example.ElecIdea.controller;

import com.example.ElecIdea.model.Project;
import com.example.ElecIdea.service.ProjectService;
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
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{nif}/recent")
    public ResponseEntity<List<Map<String, Object>>> getRecentProjectByNif(@PathVariable String nif) {
        List<Project> recentProjects = projectService.getRecentProjectByNif(nif);
        
        if (recentProjects != null && !recentProjects.isEmpty()) {
            List<Map<String, Object>> response = new ArrayList<>();
            
            for (Project project : recentProjects) {
                Map<String, Object> projectData = new HashMap<>();
                projectData.put("projectName", project.getName());
                projectData.put("projectType", project.getType());
                projectData.put("projectDate", project.getDate());
                projectData.put("projectInfo", project.getInfo());
                
                
                if (project.getClient() != null) {
                    projectData.put("clientName", project.getClient().getName());
                } else {
                    projectData.put("clientName", "Cliente no disponible");
                }
                
                response.add(projectData);
            }

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }
}

