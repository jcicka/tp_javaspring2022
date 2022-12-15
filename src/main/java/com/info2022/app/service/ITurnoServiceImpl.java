package com.info2022.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.info2022.app.dto.TurnoDto;
import com.info2022.app.entity.Turno;

import com.info2022.app.repository.ITurnoDao;

import com.info2022.app.wrapper.TurnoWrapper;


@Service
public class ITurnoServiceImpl implements ITurnoService {

	@Autowired
	private ITurnoDao turnoDao;
	

	
	@Override
	public List<Turno> getAll() {
		// TODO Auto-generated method stub
		return turnoDao.findAll();
	}

	@Override
	public Turno findById(Long id) {
		// TODO Auto-generated method stub
		return turnoDao.findById(id).orElse(new Turno());
	}

	@Override
	public TurnoDto save(Turno turno) {
		turno = turnoDao.save(turno);
		TurnoDto turno1 = TurnoWrapper.entityToDto(turno);
		return turno1;
	}

	@Override
	public TurnoDto update(TurnoDto turnoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
