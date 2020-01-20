package com.example.projectapi.apicode.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectapi.apicode.entities.Project;
import com.example.projectapi.apicode.entities.ProjectActionList;
import com.example.projectapi.apicode.repository.ActionRepository;
import com.example.projectapi.apicode.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ActionRepository actionRepository;

	@Autowired
	ProjectActionList projectActionList;
	
	@RequestMapping("/project/all")
	public List<Project> showAllProject(){
		return (List<Project> ) projectRepository.findAll();
	}
	
	@PostMapping("/project/create")
	@ResponseBody
	public Project createProject(@Valid @RequestBody Project project) {
		projectRepository.save(project);
		return project;
	}
	
	@RequestMapping("/project/view/{project_id}")
	@ResponseBody
	public ResponseEntity<ProjectActionList> showAProjectDetail(@PathVariable("project_id") int project_id) {
		if( projectRepository.existsById(project_id) ) {
			
			Project p = projectRepository.getOneProject(project_id);
			
			projectActionList.setId(p.getId());
			projectActionList.setName(p.getName());
			projectActionList.setDescription(p.getDescription());
			projectActionList.setCompleted(p.getCompleted());
			
			List act = actionRepository.getSetOfActionsForAProject(project_id);
			
			projectActionList.setAction(act);
			
			return new ResponseEntity<ProjectActionList>(projectActionList, HttpStatus.OK);
				
		}else {
			return new ResponseEntity<ProjectActionList>(projectActionList, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	

}
