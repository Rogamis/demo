package com.example.demo.controller;

import com.example.demo.entity.ProjectEntity;
import com.example.demo.exception.ProjectAlreadyExistException;
import com.example.demo.model.Project;
import com.example.demo.pojo.ErrorResponse;
import com.example.demo.pojo.ProjectResponse;
import com.example.demo.pojo.ProjectsResponse;
import com.example.demo.service.ProjectService;
import com.example.demo.exception.RequiredFieldsException;
import com.example.demo.exception.CustomMessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity getAllProjects() {
        try {
            List<Project> allProjects = projectService.getAllProjects();
            return ResponseEntity.ok().body(new ProjectsResponse(allProjects));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new ErrorResponse("Some error occurred"));
        }
    }
    @PostMapping
    public ResponseEntity createProject(@RequestBody ProjectEntity projectEntity) {
        try {
            Project project = projectService.createProject(projectEntity);
            return ResponseEntity.ok().body(new ProjectResponse(project));
        } catch (RequiredFieldsException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        } catch (ProjectAlreadyExistException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        } catch (CustomMessageException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorResponse("Some error occurred"));
        }
    }
}
