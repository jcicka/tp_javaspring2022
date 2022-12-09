package com.info2022.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info2022.app.dto.UserDto;
import com.info2022.app.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {
	
	public List<User> findByLastname(String lastname);
	public UserDto findByDni(Integer dni);

}
