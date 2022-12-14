package com.info2022.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info2022.app.dto.OrganizationDto;
import com.info2022.app.entity.Organization;
import com.info2022.app.service.IOrganizationService;


@RequestMapping("api/v1/organization")
@RestController
public class OrganizationController {

	private static final Logger log = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	private IOrganizationService organizationService;
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizaciones(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Organization> organizations = organizationService.findByAll();
		response.put("organizaciones", organizations);
		return new  ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<HashMap<String, Object>> organizacione(@PathVariable(value = "id") Long id){
		HashMap<String, Object> response = new HashMap<String, Object>();
		Organization organization = organizationService.findById(id);
		response.put("organizaciones", organization);
		return new  ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newOrganization( @RequestBody @Valid OrganizationDto organizationDto) throws Exception{
		
		log.info("organizacion: "+organizationDto.toString());
		Map<String, Object> response = new HashMap<>();
		OrganizationDto newOrganization = organizationService.save(organizationDto);
		response.put("organizacion", newOrganization);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String, Object>> update(@RequestBody OrganizationDto organizationDto){
		log.info("organizacion: "+organizationDto.toString());
		Map<String, Object> response = new HashMap<>();
		OrganizationDto updateOrganization = organizationService.update(organizationDto);
		
		if(updateOrganization == null) {
			response.put("mensaje", "No se pudo actualizar la informacion de la Organización.");
		}
		
		response.put("organizacion", updateOrganization);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
}
