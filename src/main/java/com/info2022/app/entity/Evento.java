package com.info2022.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity(name ="eventos")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@Column(nullable = false, length = 120)
	private String address;
	
	private Boolean activo;
	
	@Column(nullable = false)
	private Date dateup;
	
	private Boolean ocasional;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization cod_org;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cod_turno", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Turno> turno = new HashSet<>();
	
	public Long getId() {
		return id;
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

	public Date getDateup() {
		return dateup;
	}

	public void setDateup(Date dateup) {
		this.dateup = dateup;
	}

	public Boolean getOcasional() {
		return ocasional;
	}

	public void setOcasional(Boolean ocasional) {
		this.ocasional = ocasional;
	}


	public Evento(Long id, String name, String address, Boolean activo, Date dateup, Boolean ocasional) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.activo = activo;
		this.dateup = dateup;
		this.ocasional = ocasional;
	}


	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Evento [id=" + id + ", name=" + name + ", address=" + address + ", activo=" + activo + ", dateup="
				+ dateup + ", ocasional=" + ocasional + "]";
	}

	
}
