package com.info2022.app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity(name ="eventos")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String address;
	
	private Boolean activo;
		
	@CreationTimestamp
	private LocalDate dateup;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateevento;
	
	private Long idorg;
	
	private Boolean ocasional;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization cod_org;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cod_turno", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Turno> turno = new HashSet<>();

	public Long getIdorg() {
		return idorg;
	}

	public void setIdorg(Long idorg) {
		this.idorg = idorg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Organization getCod_org() {
		return cod_org;
	}

	public void setCod_org(Organization cod_org) {
		this.cod_org = cod_org;
	}

	public Set<Turno> getTurno() {
		return turno;
	}

	public void setTurno(Set<Turno> turno) {
		this.turno = turno;
	}

	

	public Evento(Long id, String name, String address, Boolean activo, LocalDate dateup, Date dateevento, Long idorg,
			Boolean ocasional, Organization cod_org, Set<Turno> turno) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.activo = activo;
		this.dateup = dateup;
		this.dateevento = dateevento;
		this.idorg = idorg;
		this.ocasional = ocasional;
		this.cod_org = cod_org;
		this.turno = turno;
	}

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", name=" + name + ", address=" + address + ", activo=" + activo + ", dateup="
				+ dateup + ", dateevento=" + dateevento + ", idorg=" + idorg + ", ocasional=" + ocasional + ", cod_org="
				+ cod_org + ", turno=" + turno + "]";
	}

		
		
		
}
