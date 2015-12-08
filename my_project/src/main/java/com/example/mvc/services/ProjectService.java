package com.example.mvc.services;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.example.mvc.entities.Project;

public class ProjectService {

	private List<Project> projects = new LinkedList<>();

	public ProjectService() {
		Project javaProject = this.createProject("Java Project", "This is a Java Project");
		Project javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project");
		Project htmlProject = this.createProject("HTML Project", "This is an HTML project");

		this.projects.add(javaProject);
		this.projects.add(javascriptProject);
		this.projects.add(htmlProject);

	}

	public List<Project> findAll() {
		return projects;
	}
	
	public void save(Project project){
		this.projects.add(project);
	}

	public Project find(Long projectId) {
		for (int i = 0; i < projects.size(); i++) {
			if(projects.get(i).getProjectId().equals(projectId)){
				return projects.get(i);
			}
		}
		return null;
	}

	private Project createProject(String title, String description) {
		Project project = new Project();
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		
		 long LOWER_RANGE = 0; //assign lower range value
		 long UPPER_RANGE = 1000000; //assign upper range value
		 Random random = new Random();
		 long randomValue = LOWER_RANGE + 
		                           (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		
		project.setProjectId(randomValue);
		project.setSpecial(false);
		project.setType("multi");
		project.setYear("2015");
		project.setDescription(description);
		return project;
	}

}
