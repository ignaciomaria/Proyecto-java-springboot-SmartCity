package com.grupo15.SmartCity.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dispositivo")
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(name = "nombre")
	protected String nombre;
	
	@Column(name = "descripcion")
	protected String descripcion;
	
	@Column(name = "activo")
	protected boolean activo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="dispositivo")
	protected Set<Evento> eventos = new HashSet<>();
	
	@Column(name="createdate")
	@CreationTimestamp
	protected LocalDateTime createdAt;

	@Column(name="updatedate")
	@UpdateTimestamp
	protected LocalDateTime updatedAt;

	public Dispositivo(String nombre, boolean activo) {
		super();
		this.nombre = nombre;
		this.activo = activo;
	}

}
