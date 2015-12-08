package com.example.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.entities.Project;
import com.example.mvc.services.ProjectService;

@Controller
public class HomeController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/", params="projectId")
	public String goHomeAgain(Model model, @RequestParam("projectId") Long projectId){
		Project currentProject = this.projectService.find(projectId);
		model.addAttribute("currentProject", currentProject);
		return "home";
	} 
	
	@RequestMapping("/")
	public String goHome(Model model){
		Project project = new Project();
		project.setName("First Project");
		project.setDescription("Sponsored by WWE.");
		model.addAttribute("currentProject", project);
		
		return "home";
		//return "welcome";
	}
	
	
}
