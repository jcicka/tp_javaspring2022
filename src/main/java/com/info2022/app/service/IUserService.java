package com.info2022.app.service;

import java.util.List;

import com.info2022.app.dto.UserDto;
import com.info2022.app.entity.User;


public interface IUserService {

	//todos los usuarios activos
	public List<User> getAll();
	
		
	public List<User> findByLastname(String Lastname );
	
	public UserDto findByDni(Integer dni);
	
	
	//Crud
	public UserDto save(UserDto userDto);
		
	public UserDto update(UserDto userDto);
	
	public UserDto delete(Long id);

}
