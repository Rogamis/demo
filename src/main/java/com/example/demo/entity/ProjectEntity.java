package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title")
        })
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<TodoEntity> todos = new ArrayList<>();
    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private List<UserEntity> users = new ArrayList<>();

    public ProjectEntity() {
    }

    public ProjectEntity(String title, String description) {
        this.title = title;
        this.description = description;
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

    public List<TodoEntity> getTodo() {
        return todos;
    }

    public void setTodo(List<TodoEntity> tasks) {
        this.todos = todos;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}