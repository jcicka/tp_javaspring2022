package com.info2022.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info2022.app.dto.UserDto;
import com.info2022.app.entity.User;
import com.info2022.app.repository.IUserDao;
import com.info2022.app.wrapper.UserWrapper;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public List<User> findByLastname(String Lastname) {
		// TODO Auto-generated method stub
		return userDao.findByLastname(Lastname);
	}
	
	@Override
	public UserDto findByDni(Integer dni) {
		// TODO Auto-generated method stub
		return userDao.findByDni(dni);
	}

	@Override
	public UserDto save(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = UserWrapper.dtoToEntity(userDto);
		user = userDao.save(user);
		userDto = UserWrapper.entityToDto(user);
		return userDto;
	}

	
	@Override
	public UserDto update(UserDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
