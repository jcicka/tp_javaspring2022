package com.info2022.app.service;

import java.util.List;


import com.info2022.app.dto.TurnoDto;

import com.info2022.app.entity.Turno;

public interface ITurnoService {

	public List<Turno> getAll();
	
	
	public List<Turno> findByName(String name );
	
		
	//Crud
	public TurnoDto save(Turno turno);
		
	public TurnoDto update(TurnoDto turnoDto);
	
	public boolean delete(Long id);
	
}
