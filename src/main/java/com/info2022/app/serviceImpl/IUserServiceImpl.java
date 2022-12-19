package com.info2022.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info2022.app.dto.UserDto;
import com.info2022.app.entity.User;
import com.info2022.app.repository.IUserDao;
import com.info2022.app.service.IUserService;
import com.info2022.app.wrapper.UserWrapper;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(new User());
	}

	@Override
	public List<User> findByLastname(String Lastname) {
		// TODO Auto-generated method stub
		return userDao.findByLastnameLike(Lastname);
	}
	
	@Override
	public UserDto findByDni(Integer dni) {
		// TODO Auto-generated method stub
		return UserWrapper.entityToDto(userDao.findByDni(dni));
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
	public UserDto update(UserDto userDto) {
		User userExist = userDao.findByDni(userDto.getDni());
		//Patient patient = PatientWrapper.dtoToEntity(patientDto);
		if(userExist != null) {
			
			User entityToPersist = new User(); //creamos el objeto a persistir con campos nulos
			
			// seteamos los valores al objeto a persistir
			entityToPersist.setId(userExist.getId());
			entityToPersist.setDni(userExist.getDni());
			entityToPersist.setLastname(userDto.getLastname());
			entityToPersist.setName(userDto.getName());
			entityToPersist.setActivo(userDto.getActivo());
			entityToPersist.setEmail(userDto.getEmail());
			entityToPersist.setPassword(userExist.getPassword());
			//
			
			//persistimos el objeto
			userExist = userDao.save(entityToPersist);
			userDto = UserWrapper.entityToDto(userExist);
			return userDto;
		}
		
		
		return null;
	}

	@Override
	public boolean delete(Integer dni) {
		User userExist = userDao.findByDni(dni);
		
		if(userExist != null) {
			
			User entityToPersist = new User(); //creamos el objeto a persistir con campos nulos
			
			// seteamos los valores al objeto a persistir
			entityToPersist.setId(userExist.getId());
			entityToPersist.setDni(userExist.getDni());
			entityToPersist.setLastname(userExist.getLastname());
			entityToPersist.setName(userExist.getName());
			entityToPersist.setActivo(false);
			entityToPersist.setEmail(userExist.getEmail());
			entityToPersist.setPassword(userExist.getPassword());
			//
			
			//persistimos el objeto
			userExist = userDao.save(entityToPersist);
			return true;
		
		}
		return false;
	}

	
}
