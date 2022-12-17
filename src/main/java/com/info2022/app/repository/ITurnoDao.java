package com.info2022.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.info2022.app.entity.Turno;

@Repository
public interface ITurnoDao extends JpaRepository<Turno, Long> {
	
	//public List<Turno> findByIdOrg(Long id);

}
