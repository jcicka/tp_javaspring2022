package com.info2022.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity(name="turnos")
public class Turno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	private Date dateup;
	
	private Boolean activo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Evento cod_turno;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="turno_user", joinColumns = @JoinColumn(name="turno_id"), 
	inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<User> user = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Turno(Long id, String codigo, Date dateup, Boolean activo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.dateup = dateup;
		this.activo = activo;
	}

	public Turno() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", codigo=" + codigo + ", dateup=" + dateup + ", activo=" + activo + "]";
	}
	
	//@OneToOne
	//private Evento evento;
	

}