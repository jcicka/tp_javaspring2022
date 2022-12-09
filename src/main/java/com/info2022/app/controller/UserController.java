package com.info2022.app.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Map<String, Object>> all(){
		Map<String, Object> response = new HashMap<>();
		List<User> users = new ArrayList<>();
		response.put("usuarios", users);		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		
	}
	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newUser( @RequestBody @Valid UserDto userDto) throws Exception{
		
		log.info("usuario: "+userDto.toString());
		Map<String, Object> response = new HashMap<>();
		UserDto newUser = userService.save(userDto);
		response.put("paciente", newUser);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
}
