package com.example.projectapi.apicode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectapi.apicode.entities.Project;
import com.example.projectapi.apicode.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
}
