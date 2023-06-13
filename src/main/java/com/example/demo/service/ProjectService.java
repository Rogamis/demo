package com.example.demo.service;

import com.example.demo.entity.ProjectEntity;
import com.example.demo.exception.CustomMessageException;
import com.example.demo.exception.ProjectAlreadyExistException;
import com.example.demo.exception.RequiredFieldsException;
import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;

    public List<Project> getAllProjects() {
        List<ProjectEntity> projectEntities = projectRepo.findAll();
        return projectEntities.stream().map(Project::toModel).collect(Collectors.toList());
    }

    public Project createProject(ProjectEntity projectEntity) throws RequiredFieldsException, CustomMessageException, ProjectAlreadyExistException {
        if (projectEntity.getTitle() == null){
            throw new RequiredFieldsException(new String[]{"title"});
        }
        if (projectEntity.getTitle().trim().equals("")){
            throw new CustomMessageException("Title should not be empty");
        }
        if (projectRepo.existsByTitle(projectEntity.getTitle())){
            throw new ProjectAlreadyExistException("Project", "title", projectEntity.getTitle());
        }
        projectRepo.save(projectEntity);
        return Project.toModel(projectEntity);
    }
}
