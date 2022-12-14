package com.info2022.app.wrapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.info2022.app.dto.EventoDto;
import com.info2022.app.entity.Evento;
import com.info2022.app.entity.Organization;
import com.info2022.app.repository.IOrganizationDao;
import com.info2022.app.service.IOrganizationImpl;


public class EventoWrapper {
	
	@Autowired
	static
	IOrganizationImpl organizationDao;
	
	public static Evento dtoToEntity(EventoDto dto) {		
		
		
		
		if(dto == null) return new Evento();
		
		Evento entity = new Evento();
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setDateup(dto.getDateup());
		entity.setActivo(dto.getActivo());
		entity.setCod_org(dto.getCod_org());
		entity.setDateevento(dto.getDateevento());
		entity.setOcasional(dto.getOcasional());
		
		
		return entity;
	}
	
	public static EventoDto entityToDto(Evento entity) {
		if(entity == null) return new EventoDto();
		
		EventoDto dto = new EventoDto();
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		dto.setDateup(entity.getDateup());
		dto.setActivo(entity.getActivo());
		Organization organization = new Organization();
		try {
			
			organization = organizationDao.findById(entity.getCod_org().getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dto.setCod_org(organization);
		dto.setDateevento(entity.getDateevento());
		dto.setOcasional(entity.getOcasional());
		
		return dto;
	}

}
