package com.info2022.app.dto;



import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
	
	@NotBlank(message = "El campo nombre no puede estar vacio")
	@Size(min = 4,  max= 40, message = "El nombre debe ser menor a 4 caracteres y mayor a 40.")
	private String name;
	
	@NotBlank(message = "El campo apellido no puede estar vacio")
	@Size(min = 4, max = 30, message = "El apellido debe ser menor a 4 caracteres y mayor a 30.")
	private String lastname;
	
	@Column(unique= true)
	@NotNull(message="El campo dni no puede ser nulo")
	private Integer dni;
	
	private Boolean activo;
	
	private String email;
	
	@NotBlank(message = "El campo password no puede estar vacio")
	private String password;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(
			@NotBlank(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 40, message = "El nombre debe ser menor a 4 caracteres y mayor a 40.") String name,
			@NotBlank(message = "El campo apellido no puede estar vacio") @Size(min = 4, max = 30, message = "El apellido debe ser menor a 4 caracteres y mayor a 30.") String lastname,
			@NotNull(message = "El campo dni no puede ser nulo") Integer dni, Boolean activo, String email,
			String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.activo = activo;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", lastname=" + lastname + ", dni=" + dni + ", activo=" + activo + ", email="
				+ email +  "]";
	}

}
