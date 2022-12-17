package com.info2022.app.service;

import java.util.List;


import com.info2022.app.dto.TurnoDto;

import com.info2022.app.entity.Turno;

public interface ITurnoService {

	public List<Turno> getAll();
	
	List<Turno> getByOrg(Long id);
		
	public Turno findById(Long id );
	
		
	//Crud
	public TurnoDto save(TurnoDto turnoDto);
		
	public TurnoDto update(TurnoDto turnoDto);
	
	public boolean delete(Long id);
	
}
