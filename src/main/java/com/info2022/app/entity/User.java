package com.info2022.app.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;


@Entity(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Debe ingresar un nombre")
	private String name;
	
	@NotBlank
	private String lastname;
	
	@Column	
	private Integer dni;
	
	@Column	
	private Boolean activo;
	
	@Column	
	private String email;
	
	@Column	
	private String password;
	
	@ManyToMany(mappedBy = "user")
	private Set<Turno> turno = new HashSet<>();

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

	public User(Long id, String name, String lastname, Integer dni, Boolean activo, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.activo = activo;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", dni=" + dni + ", activo=" + activo
				+ ", email=" + email + ", password=" + password + "]";
	}

}
