package com.example.mvc.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.example.mvc.entities.Resource;

public class ResourceService {

	private List<Resource> resources = new LinkedList<>();

	public ResourceService() {
		Resource res1 = this.createResource("Engineer", "this is engineer type resource");
		Resource res2 = this.createResource("Driver", "this is driver type resource");
		Resource res3 = this.createResource("Accountant", "this is accountant type resource");

		this.resources.add(res1);
		this.resources.add(res2);
		this.resources.add(res3);

	}

	public List<Resource> findAll() {
		return resources;
	}

	public void save(Resource res) {
		this.resources.add(res);
	}

	public Resource find(Long resId) {
		for (int i = 0; i < resources.size(); i++) {
			if (resources.get(i).getResourceId().equals(resId)) {
				return resources.get(i);
			}
		}
		return null;
	}

	private Resource createResource(String name, String type) {
		Resource res = new Resource();
		res.setName(name);
		res.setType(type);
		long LOWER_RANGE = 0; // assign lower range value
		long UPPER_RANGE = 1000000; // assign upper range value
		Random random = new Random();
		long randomValue = LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE));
		res.setResourceId(randomValue);

		return res;
	}

}
