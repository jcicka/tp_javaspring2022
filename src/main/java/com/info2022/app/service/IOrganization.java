package com.info2022.app.service;

import java.util.List;

import com.info2022.app.entity.Organization;

public interface IOrganization {
	
	public Organization findById(Long id);
	public List<Organization> findByAll();
	

}
