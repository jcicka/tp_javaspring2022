package com.info2022.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.info2022.app.entity.Organization;

@Repository
public interface IOrganizationDao extends JpaRepository<Organization, Long>{

	@Query("select u from organizations u where u.name = ?1")
	public List<Organization> findByname(String name);
	public Organization findByCuit(Integer cuit);
	public Optional<Organization> findById(Long id);
}