package com.info2022.app.service;

import java.util.List;

import com.info2022.app.dto.EventoDto;
import com.info2022.app.entity.Evento;


public interface IEventoService {
	
	public List<Evento> getAll();
	
	
	public List<Evento> findByName(String name );
	
		
	//Crud
	public EventoDto save(Evento evento);
		
	public EventoDto update(EventoDto eventoDto);
	
	public boolean delete(Long id);
	

}
