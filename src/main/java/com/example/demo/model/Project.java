package com.example.demo.model;

import com.example.demo.entity.ProjectEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Project {
    private Long id;
    private String title;
    private String description;
    private int todosCount;
    private List<User> users;

    public static Project toModel(ProjectEntity entity) {
        Project model = new Project();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setTodosCount(entity.getTodo().size());
        if (entity.getUsers() != null) {
            model.setUsers(entity.getUsers().stream()
                    .map(User::toModel).collect(Collectors.toList()));
        }
        return model;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTodosCount() {
        return todosCount;
    }

    public void setTodosCount(int todosCount) {
        this.todosCount = todosCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}




