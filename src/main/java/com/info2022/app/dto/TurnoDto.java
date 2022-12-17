package com.info2022.app.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.info2022.app.entity.Evento;
import com.info2022.app.entity.User;

public class TurnoDto {

	@Column(nullable = false)
	private String codigo;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateup;
	
	private Boolean activo;
	
	private Long idevento;
	
	private Long iduser;
	
	private Evento cod_turno;
	
	private Set<User> user = new HashSet<>();
	
	
	public Evento getCod_turno() {
		return cod_turno;
	}

	public void setCod_turno(Evento cod_turno) {
		this.cod_turno = cod_turno;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	
	public Long getIdevento() {
		return idevento;
	}

	public void setIdevento(Long idevento) {
		this.idevento = idevento;
	}

	
	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDateup() {
		return dateup;
	}

	public void setDateup(Date dateup) {
		this.dateup = dateup;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public TurnoDto(String codigo, Date dateup, Boolean activo) {
		super();
		this.codigo = codigo;
		this.dateup = dateup;
		this.activo = activo;
	}

	public TurnoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
