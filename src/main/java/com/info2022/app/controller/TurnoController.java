package com.info2022.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.info2022.app.dto.TurnoDto;
import com.info2022.app.entity.Evento;

import com.info2022.app.entity.Turno;
import com.info2022.app.entity.User;

import com.info2022.app.service.IEventoService;
import com.info2022.app.service.ITurnoService;
import com.info2022.app.service.IUserService;

@RequestMapping("api/v1/turno")
@RestController
public class TurnoController {
	private static final Logger log = LoggerFactory.getLogger(EventoController.class);
	
	@Autowired
	private ITurnoService turnoService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IEventoService eventoService;
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> all(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Turno> turnos = turnoService.getAll();
		response.put("eventos", turnos);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		
	}
	@PostMapping("/user/{id_user}")
	public ResponseEntity<Map<String, Object>> newEvento(
			@PathVariable("id_user") Long id_user, @RequestBody @Valid Turno turno) {
		
		log.info("turno: "+turno.toString());
		Evento eventoexist = eventoService.findById(turno.getCod_turno().getId());
		User userexist = userService.findById(id_user);
		Map<String, Object> response = new HashMap<>();
		if (eventoexist== null) {
			response.put("no existe la organizacion", "");
		}else {
			turno.setCod_turno(eventoexist);
			turno.agregarUser(userexist);
			TurnoDto newTurno = turnoService.save(turno);
			
			response.put("evento", newTurno);
		}
			
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
}
