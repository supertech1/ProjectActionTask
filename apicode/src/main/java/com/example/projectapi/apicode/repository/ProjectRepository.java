package com.example.projectapi.apicode.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projectapi.apicode.entities.Project;

@Repository("projectRepository")
public interface ProjectRepository extends CrudRepository<Project, Integer>{
		
	@Query(value = "SELECT * FROM project AS p WHERE id=:project_id", nativeQuery=true)
	public Project getOneProject(@Param("project_id") int project_id);

}
