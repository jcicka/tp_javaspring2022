package com.info2022.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.info2022.app.dto.EventoDto;
import com.info2022.app.entity.Evento;
import com.info2022.app.entity.Organization;
import com.info2022.app.repository.IEventoDao;
import com.info2022.app.repository.IOrganizationDao;
import com.info2022.app.wrapper.EventoWrapper;


@Service
public class EventoServiceImpl implements IEventoService{
	
	@Autowired
	private IEventoDao eventoDao;
	
	@Autowired
	private IOrganizationDao organizationDao;
	
	@Override
	public Evento findById(Long id) {
		// TODO Auto-generated method stub
		return eventoDao.findById(id).orElse(new Evento());
	}
	
	@Override
	public List<Evento> getAll() {
		// TODO Auto-generated method stub
		return eventoDao.findAll();
	}

	@Override
	public List<Evento> findByName(String name) {
		// TODO Auto-generated method stub
		return eventoDao.findByNameLike(name);
	}

	@Override
	public EventoDto save(Evento evento) {
		
		evento = eventoDao.save(evento);
		EventoDto evento1 = EventoWrapper.entityToDto(evento);
		
		return evento1;
	}

	@Override
	public EventoDto update(EventoDto eventoDto) {
		Evento eventoExist = eventoDao.findById(eventoDto.getId()).orElse(new Evento());
		//Patient patient = PatientWrapper.dtoToEntity(patientDto);
		Organization organizationExist = organizationDao.findById(eventoDto.getCod_org().getId()).orElse(new Organization());
		if(eventoExist != null) {
			
			Evento entityToPersist = new Evento(); //creamos el objeto a persistir con campos nulos
			
			// seteamos los valores al objeto a persistir
			entityToPersist.setId(eventoExist.getId());
			entityToPersist.setName(eventoDto.getName());
			entityToPersist.setAddress(eventoDto.getAddress());
			entityToPersist.setActivo(eventoDto.getActivo());
			entityToPersist.setDateevento(eventoDto.getDateevento());
			entityToPersist.setOcasional(eventoDto.getOcasional());
			entityToPersist.setCod_org(organizationExist);
			
			//persistimos el objeto
			eventoExist = eventoDao.save(entityToPersist);
			eventoDto = EventoWrapper.entityToDto(eventoExist);
			return eventoDto;
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		Evento eventoExist = eventoDao.findById(id).orElse(new Evento());
		
		if(eventoExist != null) {
			
			Evento entityToPersist = new Evento(); //creamos el objeto a persistir con campos nulos
			
			// seteamos los valores al objeto a persistir
			entityToPersist.setId(eventoExist.getId());
			entityToPersist.setName(eventoExist.getName());
			entityToPersist.setAddress(eventoExist.getAddress());
			entityToPersist.setActivo(false);
			entityToPersist.setDateevento(eventoExist.getDateevento());
			entityToPersist.setCod_org(eventoExist.getCod_org());
			entityToPersist.setOcasional(eventoExist.getOcasional());
			//
			
			//persistimos el objeto
			eventoExist = eventoDao.save(entityToPersist);
			return true;
		
		}
		return false;
	}

	

}
