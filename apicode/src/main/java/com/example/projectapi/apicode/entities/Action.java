package com.example.projectapi.apicode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="action")
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private int project_id;
	private String description, note;
	private boolean completed;
	
	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	public Action(int project_id, String description, String note, boolean completed) {
		super();
		this.project_id = project_id;
		this.description = description;
		this.note = note;
		this.completed = completed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	} 
	
	
	
	
	
	

}
