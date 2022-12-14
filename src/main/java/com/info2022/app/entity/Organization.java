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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity(name = "organizations")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(length = 45)
	private String name;
	
	private Long cuit;
	
	private Date dateup;
	
	private String email;
	
	private String address;
	
	@Column(name="address_altura")
	private Integer addressAltura;
	
	private Integer phone;
	
	private Boolean activo;
	
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cod_org", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Evento> evento = new HashSet<>();

	

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



	public Long getCuit() {
		return cuit;
	}



	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}



	public Date getDateup() {
		return dateup;
	}



	public void setDateup(Date dateup) {
		this.dateup = dateup;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Integer getAddressAltura() {
		return addressAltura;
	}



	public void setAddressAltura(Integer addressAltura) {
		this.addressAltura = addressAltura;
	}



	public Integer getPhone() {
		return phone;
	}



	public void setPhone(Integer phone) {
		this.phone = phone;
	}



	public Boolean getActivo() {
		return activo;
	}



	public void setActivo(Boolean activo) {
		this.activo = activo;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Set<Evento> getEvento() {
		return evento;
	}



	public void setEvento(Set<Evento> evento) {
		this.evento = evento;
	}



	public Organization(Long id, @NotBlank String name, Long cuit, Date dateup, String email, String address,
			Integer addressAltura, Integer phone, Boolean activo, String password, Set<Evento> evento) {
		super();
		this.id = id;
		this.name = name;
		this.cuit = cuit;
		this.dateup = dateup;
		this.email = email;
		this.address = address;
		this.addressAltura = addressAltura;
		this.phone = phone;
		this.activo = activo;
		this.password = password;
		this.evento = evento;
	}



	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", cuit=" + cuit + ", dateup=" + dateup + ", email="
				+ email + ", address=" + address + ", addressAltura=" + addressAltura + ", phone=" + phone + ", activo="
				+ activo + ", password=" + password + ", evento=" + evento + "]";
	}



	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
