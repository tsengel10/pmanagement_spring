package com.example.mvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mvc.entities.Project;
import com.example.mvc.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "find/{projectId}")
	public @ResponseBody Project findProjectObject(Model model, @PathVariable("projectId") Long projectId) {
		return this.projectService.find(projectId);
	}

	@RequestMapping("/find")
	public String find(Model model) {
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}

	@RequestMapping(value = "/{projectId}")
	public String findProject(Model model, @PathVariable("projectId") Long projectId) {
		model.addAttribute("project", this.projectService.find(projectId));
		return "project";
	}

	@SuppressWarnings("serial")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(@ModelAttribute Project project, HttpSession session, Model model) {
		session.setAttribute("token", "1234");

		model.addAttribute("yearOptions", new ArrayList<String>() {
			{
				add("");
				add("Single Year");
				add("Multi Year");
			}
		});
		return "project_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	// Data binding used here using @ModelAttribute Project project
	// Errors object must come right after @ModelAttribute
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors, Model model,
			RedirectAttributes attr) {

		if (!errors.hasErrors()) {
			System.out.println(errors.getAllErrors().toString());
			System.out.println("Project is valid");
		} else {
			System.out.println("Project obj is not valid");
			return "project_add";
		}

		model.addAttribute("project", project);
		System.out.println(project);
		
		project.setProjectId(55L);
		this.projectService.save(project);
		
		//There is also attr.addFlashAttribute - that puts map in session
		attr.addAttribute("projectId", project.getProjectId().toString());
		
		//Instead of jumping to root, can redirect to /project/{projectId} - SHOW
		return "redirect:/";
	}


}
