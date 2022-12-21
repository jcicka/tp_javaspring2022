package com.info2022.app.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.info2022.app.dto.TurnoDto;
import com.info2022.app.entity.Evento;
import com.info2022.app.entity.Turno;
import com.info2022.app.entity.User;
import com.info2022.app.repository.ITurnoDao;
import com.info2022.app.service.IEventoService;
import com.info2022.app.service.ITurnoService;
import com.info2022.app.service.IUserService;
import com.info2022.app.wrapper.TurnoWrapper;


@Service
public class ITurnoServiceImpl implements ITurnoService {

	@Autowired
	private ITurnoDao turnoDao;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IEventoService eventoService;
	
	@Override
	public List<Turno> getAll() {
		// TODO Auto-generated method stub
		return turnoDao.findAll();
	}
	
	@Override
	public List<Turno> getByOrg(Long id) {
		// TODO Auto-generated method stub
		List<Turno> turnos;
		turnos = turnoDao.findAll();
		List<Turno> turnos1 = new  ArrayList<>();
		
		turnos.forEach((e) -> {
			if(e.getCod_turno().getCod_org().getId().equals(id)) {
				turnos1.add(e);
				}
			}
		);
		
		return turnos1;
	}

	@Override
	public Turno findById(Long id) {
		// TODO Auto-generated method stub
		return turnoDao.findById(id).orElse(new Turno());
	}

	@Override
	public TurnoDto save(TurnoDto turnoDto) {
		Evento eventoexist = eventoService.findById(turnoDto.getIdevento());
		User userexist = userService.findById(turnoDto.getIduser());
		Turno turno = new Turno();
		
		
		if (eventoexist== null || userexist== null)  {
			//response.put("no existe el evento o el usuario", "");
		}else {
			
			turno = TurnoWrapper.dtoToEntity(turnoDto);
			turno.setCod_turno(eventoexist);
			turno.agregarUser(userexist);
			if (eventoexist.getOcasional()) {
				turno.setDateevento(eventoexist.getDateevento());
			}else {
				turno.setDateevento(turnoDto.getDateevento());
			}
		}
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
