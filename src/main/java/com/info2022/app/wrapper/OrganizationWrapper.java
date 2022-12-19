package com.info2022.app.wrapper;

import com.info2022.app.dto.OrganizationDto;
import com.info2022.app.entity.Organization;

public class OrganizationWrapper {

	public static Organization dtoToEntity(OrganizationDto dto) {		
		if(dto == null) return new Organization();
		
		Organization entity = new Organization();
		entity.setName(dto.getName());
		entity.setCuit(dto.getCuit());
		entity.setDateup(dto.getDateup());
		entity.setAddress(dto.getAddress());
		entity.setAddressAltura(dto.getAddressAltura());
		entity.setPhone(dto.getPhone());
		entity.setEmail(dto.getEmail());
		entity.setActivo(dto.getActivo());
		entity.setPassword(dto.getPassword());
		
		return entity;
	}
	
	public static OrganizationDto entityToDto(Organization entity) {
		if(entity == null) return new OrganizationDto();
		
		OrganizationDto dto = new OrganizationDto();
		dto.setName(entity.getName());
		dto.setCuit(entity.getCuit());
		dto.setDateup(entity.getDateup());
		dto.setAddress(entity.getAddress());
		dto.setAddressAltura(entity.getAddressAltura());
		dto.setPhone(entity.getPhone());
		dto.setEmail(entity.getEmail());
		dto.setActivo(entity.getActivo());
		dto.setPassword(entity.getPassword());
		
		return dto;
	}
}
