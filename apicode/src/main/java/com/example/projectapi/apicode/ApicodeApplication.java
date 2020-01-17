package com.example.projectapi.apicode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.projectapi.apicode.entities.Project;
import com.example.projectapi.apicode.services.DAOService;
import com.example.projectapi.apicode.services.ProjectService;
import com.example.testjpa.mytest.entity.User;

@SpringBootApplication
public class ApicodeApplication implements CommandLineRunner {

	@Autowired
	private ProjectService projectService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ApicodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		demo();
		
	}
	
	public void demo() {
		for(Project p : projectService.findAllProjects() ) {
			System.out.println("Project Id"+ p.getId() + "\n Project name"+p.getName());
		}
	}
	
	

}
