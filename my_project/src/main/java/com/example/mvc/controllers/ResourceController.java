package com.example.mvc.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.mvc.entities.Resource;
import com.example.mvc.exception.CustomException;
import com.example.mvc.services.ResourceService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
// Used @SessionAttributes to not calling everytime resource() which is
// annotated with
// @ModelAttribute but only one for session. Will call it for the first time and
// will save it in session

public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody String handleUpload(@RequestParam("file") MultipartFile file){
		if(!file.isEmpty()){
			return "The file size is "+file.getSize();
		}
		else{
			return "There was a problem";
		}
	}
	
	@RequestMapping("/add")
	public String add(Model model) {

		// @ModelAttribute annotated methods will invoked everytime /add or
		// /save called
		// Basically everytime
		System.out.println("Invoking add()...");
		return "resource_add";
	}

	@RequestMapping(value = "/{resourceId}")
	@ResponseBody
	//Path variable needs to be converted into resource obj
	public Resource findResource(Model model, @PathVariable("resourceId") Resource resource) {
		return resource;
	}

	@RequestMapping("/find")
	public String find(Model model) {
		model.addAttribute("resources", this.resourceService.findAll());
		return "resources";
	}

	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource) {
		System.out.println("Invoking review()...");
		return "resource_review";
	}

	@RequestMapping("/save")
	// Data binding...
	public String save(@ModelAttribute Resource resource, SessionStatus status) throws CustomException {
		System.out.println(resource);
		System.out.println("Invoking save()...");

		if (resource.getName().equals("custom exception")) {
			// This will trigger the method annotated @ExceptionHandler which is
			// handleError()
			throw new CustomException("There was an CustomException...");
		}

		if (resource.getName().equals("global exception")) {
			// This will handled by Global handler
			throw new RuntimeException("There was an RunTimeException...");
		}

		// When redirect it will not display the previous data on the form
		status.setComplete();
		return "redirect:/resource/add";
	}

	@RequestMapping("/request")
	@ResponseBody
	// returning value will be returned directly to client.
	public String request(@RequestBody String resource) {
		// TODO: Send out an email for approval
		System.out.println(resource);
		return "Request has been send for approval";
	}

	@ModelAttribute("resource")
	// Result is same as model.addAttribute(key, value);
	public Resource getResource() {
		System.out.println("Invoking RESOURCE()...");
		return new Resource();
	}

	@ModelAttribute("typeOptions")
	// Result is same as model.addAttribute(key, value);
	public LinkedHashMap<String, String> getOptions() {
		LinkedHashMap<String, String> options = new LinkedHashMap<>();
		options.put("material", "Material");
		options.put("other", "Other");
		options.put("staff", "Staff");
		options.put("tech", "Technical Equipment");
		return options;
	}

	@ModelAttribute("radioOptions")
	// Result is same as model.addAttribute(key, value);
	public LinkedHashMap<String, String> getRadios() {
		LinkedHashMap<String, String> radios = new LinkedHashMap<>();
		radios.put("hours", "Hours");
		radios.put("piece", "Piece");
		radios.put("ton", "Ton");
		return radios;
	}

	@ModelAttribute("checkOptions")
	// Result is same as model.addAttribute(key, value);
	public LinkedHashMap<String, String> getChecks() {
		LinkedHashMap<String, String> checks = new LinkedHashMap<>();
		checks.put("leadTime", "Lead Time");
		checks.put("specialRate", "Special Rate");
		checks.put("requiresApproval", "Requires Approval");
		return checks;
	}
}
