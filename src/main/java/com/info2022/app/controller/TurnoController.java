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
import com.info2022.app.entity.Turno;
import com.info2022.app.service.ITurnoService;


@RequestMapping("api/v1/turno")
@RestController
public class TurnoController {
	private static final Logger log = LoggerFactory.getLogger(EventoController.class);
	
	@Autowired
	private ITurnoService turnoService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> all(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Turno> turnos = turnoService.getAll();
		response.put("turnos", turnos);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/organization/{id}")
	public ResponseEntity<HashMap<String, Object>> byOrganizatio(@PathVariable("id")Long id){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Turno> turnos = turnoService.getByOrg(id);
		response.put("turnos de la Org", turnos);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newTurno(@RequestBody @Valid TurnoDto turnoDto) {
		
		log.info("turno: "+turnoDto.toString());
		Map<String, Object> response = new HashMap<>();
		
		TurnoDto newTurno = turnoService.save(turnoDto);
	
		if (newTurno.getCodigo()== ""){
			response.put("turno","no se pudo agregar el turno");
		}else {
			response.put("turno", newTurno);
		}
		
		
			
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
}
