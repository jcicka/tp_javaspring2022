package com.info2022.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info2022.app.entity.Evento;

public interface IEventoDao extends JpaRepository<Evento, Long>{

}
