package com.example.mvc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.mvc.entities.Project;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Project project = (Project) obj;
		
		if(project.getName().length() < 5){
			errors.rejectValue("name","project.name","Name is too short!");
		}
	}

}
