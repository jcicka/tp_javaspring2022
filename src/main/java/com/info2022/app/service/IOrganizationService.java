package com.info2022.app.service;

import java.util.List;

import com.info2022.app.dto.OrganizationDto;
import com.info2022.app.entity.Organization;


public interface IOrganizationService {
	
	public Organization findById(Long id);
	
	public List<Organization> findByAll();
	
	public List<Organization> findByname(String name );
	
	public OrganizationDto findByCuit(Integer cuit);
	
	
	//Crud
	public OrganizationDto save(OrganizationDto organizationDto);
		
	public OrganizationDto update(OrganizationDto organizationDto);
	
	public OrganizationDto delete(Long id);
	

}
