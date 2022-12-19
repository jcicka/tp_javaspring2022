package com.info2022.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrganizationDto {
	
	private Long id;

	@NotBlank(message = "El campo nombre no puede estar vacio")
	@Size(min = 4,  max= 80, message = "El nombre debe ser mayor a 4 caracteres y menor a 80.")
	private String name;

	@NotNull(message="El cuit no puede ser nulo")
	@Column(unique= true)
	private Long cuit;
	
	private Date dateup;
	
	private String email;
	
	@Column(nullable = false, length = 120)
	private String address;
	
	@Column(name="address_altura")
	private Integer addressAltura;
	
	private Integer phone;
	
	private Boolean activo;
	
	
	@NotBlank(message = "El campo Password no puede estar vacio")
	@Size(min = 20,  max= 40, message = "El password debe ser mayor a 20 caracteres y menor a 40.")
	private String password;

	
	public Long getId() {
		return id;
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

	public String getPassword() {
		return password;
	}
	
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	public OrganizationDto(Long id,
			@NotBlank(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 80, message = "El nombre debe ser mayor a 4 caracteres y menor a 80.") String name,
			@NotNull(message = "El cuit no puede ser nulo") Long cuit, Date dateup, String email, String address,
			Integer addressAltura, Integer phone, Boolean activo,
			@NotBlank(message = "El campo Password no puede estar vacio") @Size(min = 20, max = 40, message = "El password debe ser mayor a 20 caracteres y menor a 40.") String password) {
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
	}

	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrganizationDto [id=" + id + ", name=" + name + ", cuit=" + cuit + ", dateup=" + dateup + ", email="
				+ email + ", address=" + address + ", addressAltura=" + addressAltura + ", phone=" + phone + ", activo="
				+ activo + ", password=" + password + "]";
	}

	
	
}
