package com.info2022.app.wrapper;

import com.info2022.app.dto.TurnoDto;
import com.info2022.app.entity.Turno;

public class TurnoWrapper {

	public static Turno dtoToEntity(TurnoDto dto) {		
		if(dto == null) return new Turno();
		
		Turno entity = new Turno();
		entity.setCodigo(dto.getCodigo());
		entity.setDateup(dto.getDateup());
		entity.setActivo(dto.getActivo());
		
		
		
		return entity;
	}
	
	public static TurnoDto entityToDto(Turno entity) {
		if(entity == null) return new TurnoDto();
		
		TurnoDto dto = new TurnoDto();
		dto.setCodigo(entity.getCodigo());
		dto.setDateup(entity.getDateup());
		dto.setActivo(entity.getActivo());
		
		return dto;
	}
}
