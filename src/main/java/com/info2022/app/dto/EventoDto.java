package com.info2022.app.dto;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.info2022.app.entity.Organization;

public class EventoDto {

	@NotBlank(message = "El campo nombre no puede estar vacio")
	@Size(min = 4,  max= 80, message = "El nombre debe ser menor a 4 caracteres y mayor a 80.")
	private String name;
	
	@Column(nullable = false, length = 120)
	private String address;
	
	private Boolean activo;
	
	private Long idorg;
	
	@Column(nullable = false)
	private LocalDate dateup;
	
	private Date dateevento;
	
	private Organization cod_org;
	
	private Boolean ocasional;

	public Long getIdorg() {
		return idorg;
	}

	public void setIdorg(Long idorg) {
		this.idorg = idorg;
	}

	public Organization getCod_org() {
		return cod_org;
	}

	public void setCod_org(Organization cod_org) {
		this.cod_org = cod_org;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public LocalDate getDateup() {
		return dateup;
	}

	public void setDateup(LocalDate dateup) {
		this.dateup = dateup;
	}

	public Date getDateevento() {
		return dateevento;
	}

	public void setDateevento(Date dateevento) {
		this.dateevento = dateevento;
	}

	public Boolean getOcasional() {
		return ocasional;
	}

	public void setOcasional(Boolean ocasional) {
		this.ocasional = ocasional;
	}

	public EventoDto(
			@NotBlank(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 80, message = "El nombre debe ser menor a 4 caracteres y mayor a 80.") String name,
			String address, Boolean activo, LocalDate dateup, Date dateevento, Boolean ocasional) {
		super();
		this.name = name;
		this.address = address;
		this.activo = activo;
		this.dateup = dateup;
		this.dateevento = dateevento;
		this.ocasional = ocasional;
	}

	public EventoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EventoDto [name=" + name + ", address=" + address + ", activo=" + activo + ", dateup=" + dateup
				+ ", dateevento=" + dateevento + ", ocasional=" + ocasional + "]";
	}

	
}
