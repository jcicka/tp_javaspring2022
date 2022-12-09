package com.info2022.app.wrapper;


import com.info2022.app.dto.UserDto;
import com.info2022.app.entity.User;

public class UserWrapper {
	public static User dtoToEntity(UserDto dto) {		
		if(dto == null) return new User();
		
		User entity = new User();
		entity.setName(dto.getName());
		entity.setLastname(dto.getLastname());
		entity.setDni(dto.getDni());
		entity.setActivo(dto.getActivo());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		
		return entity;
	}
	
	public static UserDto entityToDto(User entity) {
		if(entity == null) return new UserDto();
		
		UserDto dto = new UserDto();
		dto.setName(entity.getName());
		dto.setLastname(entity.getLastname());
		dto.setDni(entity.getDni());
		dto.setActivo(entity.getActivo());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		
		return dto;
	}

}
