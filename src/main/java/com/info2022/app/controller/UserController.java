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

import com.info2022.app.dto.UserDto;
import com.info2022.app.entity.User;
import com.info2022.app.service.IUserService;



@RequestMapping("api/v1/user")
@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
		
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> all(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<User> usuarios = userService.getAll();
		response.put("usuarios", usuarios);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		
	}
	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newUser( @RequestBody @Valid UserDto userDto) {
		
		log.info("usuario: "+userDto.toString());
		Map<String, Object> response = new HashMap<>();
		UserDto newUser = userService.save(userDto);
		response.put("usuario", newUser);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String, Object>> update(@RequestBody UserDto userDto){
		log.info("usuario: "+userDto.toString());
		Map<String, Object> response = new HashMap<>();
		UserDto updateUser = userService.update(userDto);
		
		if(updateUser == null) {
			response.put("mensaje", "No se pudo actualizar la informacion del usuario.");
		}
		
		response.put("usuario", updateUser);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/dni/{dni}")
	public ResponseEntity<HashMap<String, Object>> usuario(@PathVariable("dni") Integer dni){
		HashMap<String, Object> response = new HashMap<String, Object>();
		UserDto usuario = userService.findByDni(dni);
		response.put("usuario", usuario);
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/apellido/{lastname}")
	public ResponseEntity<HashMap<String, Object>> buscarPorNombre(@PathVariable("lastname") String lastname) {
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<User> usuario = userService.findByLastname(lastname);
		response.put("mensaje", usuario);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{dni}/{password}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("dni") Integer dni,@PathVariable("password") String password){
		UserDto usuario = userService.findByDni(dni);
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (usuario.getPassword().equals(password) && usuario.getActivo()) {
			boolean updateUser = userService.delete(dni);
			if(updateUser == false) {
				response.put("mensaje", "No se pudo borrar la informacion del usuario.");
			}
			response.put("usuario borrado", updateUser);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}else {
			response.put("usuario o password incorrecto", "o usuario ya borrado");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		
	}
}
