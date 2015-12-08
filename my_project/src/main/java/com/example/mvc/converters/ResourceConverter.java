package com.example.mvc.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.mvc.entities.Resource;
import com.example.mvc.services.ResourceService;

public class ResourceConverter implements Converter<String, Resource> {

	@Autowired
	private ResourceService resourceService;
	
	@Override
	public Resource convert(String source) {
		Resource res = this.resourceService.find(new Long(source));
		return res;
	}

}
