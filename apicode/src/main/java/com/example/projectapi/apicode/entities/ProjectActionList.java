package com.example.projectapi.apicode.entities;

import java.util.List;

import org.springframework.stereotype.Component;

@Component

public class ProjectActionList {
	
	private int id;
	private String name;
	private String description;
	private boolean completed;
	private List action;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public List getAction() {
		return action;
	}
	public void setAction(List action) {
		this.action = action;
	}
	
	
	

}
