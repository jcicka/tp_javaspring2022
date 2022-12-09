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
	
	private Integer cuit;
	
	private Date dateup;
	
	private String email;
	
	private String address;
	
	@Column(name="address_altura")
	private Integer addressAltura;
	
	private Integer phone;
	
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

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
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

	public Integer getAddress_altura() {
		return addressAltura;
	}

	public void setAddress_altura(Integer address_altura) {
		this.addressAltura = address_altura;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Organization(Long id, String name, Integer cuit, Date dateup, String email, String address,
			Integer address_altura, Integer phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cuit = cuit;
		this.dateup = dateup;
		this.email = email;
		this.address = address;
		this.addressAltura = address_altura;
		this.phone = phone;
		this.password = password;
	}

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", cuit=" + cuit + ", dateup=" + dateup + ", email="
				+ email + ", address=" + address + ", address_altura=" + addressAltura + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	
	
	
	
}
