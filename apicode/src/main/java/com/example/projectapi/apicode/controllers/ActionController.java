package com.example.projectapi.apicode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectapi.apicode.entities.Action;
import com.example.projectapi.apicode.repository.ActionRepository;
import com.example.projectapi.apicode.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
public class ActionController {

	@Autowired
	ActionRepository actionRepository;
	@Autowired
	ProjectRepository projectRepository;
	
	@RequestMapping("/action/display_all_actions")
	@ResponseBody
	public List<Action> listActions() {
		return (List<Action>) actionRepository.findAll();
	}
	
	@PostMapping("/action/createaction/{project_id}")
	@ResponseBody
	public ResponseEntity<Action> createActionForProject(@PathVariable("project_id") int project_id, @RequestBody Action action) {
		System.out.println("hellllllllsldfsdfsdfsfs");
			if( projectRepository.existsById(project_id)) {
				action.setProject_id(project_id);
				System.out.print("hellllllllsldfsdfsdfsfs");
				actionRepository.save(action);
				return new ResponseEntity<Action>(action, HttpStatus.OK);

			}else {
				return new ResponseEntity<Action>(action, HttpStatus.FORBIDDEN);
			}
		
	}
	
	
	
	
}
