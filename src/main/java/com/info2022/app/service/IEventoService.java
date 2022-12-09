package com.info2022.app.service;

import java.util.List;

import com.info2022.app.entity.Evento;

public interface IEventoService {
	
	public List<Evento> getAll();
	
	public Evento findById(Long id);
	

}