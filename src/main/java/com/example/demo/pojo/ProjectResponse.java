package com.example.demo.pojo;

import com.example.demo.model.Project;

public class ProjectResponse {

    private Project project;

    public ProjectResponse(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}