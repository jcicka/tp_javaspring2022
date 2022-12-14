package com.info2022.app.wrapper;

import com.info2022.app.dto.EventoDto;
import com.info2022.app.entity.Evento;


public class EventoWrapper {
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
		dto.setCod_org(entity.getCod_org());
		dto.setDateevento(entity.getDateevento());
		dto.setOcasional(entity.getOcasional());
		
		return dto;
	}

}
