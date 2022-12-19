package com.info2022.app.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info2022.app.dto.OrganizationDto;
import com.info2022.app.entity.Organization;
import com.info2022.app.repository.IOrganizationDao;
import com.info2022.app.service.IOrganizationService;
import com.info2022.app.wrapper.OrganizationWrapper;


@Service 
public class IOrganizationImpl implements IOrganizationService{

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

	@Override
	public List<Organization> findByname(String name) {
		// TODO Auto-generated method stub
		return organizationDao.findByname(name);
	}

	@Override
	public OrganizationDto findByCuit(Long cuit) {
		// TODO Auto-generated method stub
		return OrganizationWrapper.entityToDto(organizationDao.findByCuit(cuit));
	}

	@Override
	public OrganizationDto save(OrganizationDto organizationDto) {
		// TODO Auto-generated method stub
		Organization organization = OrganizationWrapper.dtoToEntity(organizationDto);
		organization = organizationDao.save(organization);
		organizationDto = OrganizationWrapper.entityToDto(organization);
		return organizationDto;
	}

	@Override
	public OrganizationDto update(OrganizationDto organizationDto) {
		Organization organizationExist = organizationDao.findByCuit(organizationDto.getCuit());
		//Patient patient = PatientWrapper.dtoToEntity(patientDto);
		if(organizationExist != null) {
			
			Organization entityToPersist = new Organization(); //creamos el objeto a persistir con campos nulos
			
			// seteamos los valores al objeto a persistir
			entityToPersist.setId(organizationExist.getId());
			entityToPersist.setCuit(organizationExist.getCuit());
			entityToPersist.setDateup(organizationExist.getDateup());
			entityToPersist.setName(organizationDto.getName());
			entityToPersist.setAddress(organizationDto.getAddress());
			entityToPersist.setAddressAltura(organizationDto.getAddressAltura());
			entityToPersist.setActivo(organizationDto.getActivo());
			entityToPersist.setEmail(organizationDto.getEmail());
			entityToPersist.setPassword(organizationExist.getPassword());
			//
			
			//persistimos el objeto
			organizationExist = organizationDao.save(entityToPersist);
			organizationDto = OrganizationWrapper.entityToDto(organizationExist);
			return organizationDto;
		}
				
		return null;
	}

	@Override
	public boolean delete(Long cuit){
		Organization organizationExist = organizationDao.findByCuit(cuit);

		if(organizationExist != null) {

			Organization entityToPersist = new Organization(); //creamos el objeto a persistir con campos nulos

			// seteamos los valores al objeto a persistir
			entityToPersist.setId(organizationExist.getId());
			entityToPersist.setCuit(organizationExist.getCuit());
			entityToPersist.setDateup(organizationExist.getDateup());
			entityToPersist.setName(organizationExist.getName());
			entityToPersist.setAddress(organizationExist.getAddress());
			entityToPersist.setAddressAltura(organizationExist.getAddressAltura());
			entityToPersist.setActivo(false);
			entityToPersist.setEmail(organizationExist.getEmail());
			entityToPersist.setPassword(organizationExist.getPassword());
			//

			//persistimos el objeto
			organizationExist = organizationDao.save(entityToPersist);
			return true;

		}
		return false;
	}

	

}
