package com.info2022.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info2022.app.entity.Organization;
import com.info2022.app.repository.IOrganizationDao;

@Service 
public class IOrganizationImpl implements IOrganization{

	@Autowired
	IOrganizationDao organizationDao;
	
	
	@Override
	public Organization findById(Long id) {
		// TODO Auto-generated method stub
		return organizationDao.findById(id).orElse(new Organization());
	}

	@Override
	public List<Organization> findByAll() {
		// TODO Auto-generated method stub
		return organizationDao.findAll();
	}

}
