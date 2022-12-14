package com.info2022.app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info2022.app.entity.Evento;


@Repository
public interface IEventoDao extends JpaRepository<Evento, Long>{
	
	public List<Evento> findByNameLike(String name);
	public Evento findByName(String name);

}
