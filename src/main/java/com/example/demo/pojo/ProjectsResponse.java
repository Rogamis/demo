package com.example.demo.pojo;

import com.example.demo.model.Project;

import java.util.List;

public class ProjectsResponse {

    private List<Project> projects;

    public ProjectsResponse(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}