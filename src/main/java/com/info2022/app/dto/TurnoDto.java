package com.info2022.app.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TurnoDto {

	@Column(nullable = false)
	private String codigo;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateup;
	
	private Boolean activo;

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
