package com.info2022.app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.info2022.app.entity.Organization;
import com.info2022.app.service.IOrganization;

@RestController
public class OrganizationController {

	@Autowired
	private IOrganization organizationService;
	
	@GetMapping("/organizaciones")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizaciones(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Organization> organizations = organizationService.findByAll();
		response.put("organizaciones", organizations);
		return new  ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/organizacion/{id}")
	public ResponseEntity<HashMap<String, Object>> organizacione(@PathVariable(value = "id") Long id){
		HashMap<String, Object> response = new HashMap<String, Object>();
		Organization organization = organizationService.findById(id);
		response.put("organizaciones", organization);
		return new  ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
}
