package com.example.demo.repository;
import com.example.demo.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepo extends JpaRepository<ProjectEntity, Long> {
    Boolean existsByTitle(String title);
    Boolean existsByDescription(String description);
    @Query(value = "SELECT * FROM users JOIN user_projects ON users.id = user_projects.user_id where user_projects.project_id = :id", nativeQuery = true)
    List<Object[]> addUserToProject(@Param("id") Long id);
}