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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info2022.app.dto.EventoDto;

import com.info2022.app.entity.Evento;
import com.info2022.app.entity.Organization;
import com.info2022.app.service.IEventoService;
import com.info2022.app.service.IOrganizationService;


@RequestMapping("api/v1/evento")
@RestController
public class EventoController {
	
private static final Logger log = LoggerFactory.getLogger(EventoController.class);
	
	@Autowired
	private IEventoService eventoService;
	
	@Autowired
	private IOrganizationService organizationService;
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> all(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Evento> eventos = eventoService.getAll();
		response.put("eventos", eventos);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		
	}
	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newEvento( @RequestBody @Valid Evento evento) {
		
		log.info("evento: "+evento.toString());
		Organization orgexist = organizationService.findById(evento.getIdorg());
		Map<String, Object> response = new HashMap<>();
		if (orgexist== null) {
			response.put("no existe la organizacion", "");
		}else {
			evento.setCod_org(orgexist);
			EventoDto newEvento = eventoService.save(evento);
			
			response.put("evento", newEvento);
		}
			
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String, Object>> update(@RequestBody EventoDto eventoDto){
		log.info("evento: "+eventoDto.toString());
		Map<String, Object> response = new HashMap<>();
		EventoDto updateEvento = eventoService.update(eventoDto);
		
		if(updateEvento == null) {
			response.put("mensaje", "No se pudo actualizar la informacion del evento.");
		}
		
		response.put("evento", updateEvento);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<HashMap<String, Object>> evento(@PathVariable("name") String name){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Evento> evento = eventoService.findByName(name);
		response.put("evento", evento);
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id){
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		boolean updateEvento = eventoService.delete(id);
		
		if(updateEvento == false) {
			response.put("mensaje", "No se pudo borrar la informacion del evento.");
		}
		
		response.put("Evento borrado", updateEvento);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}

}
