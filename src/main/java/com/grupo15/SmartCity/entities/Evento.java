package com.grupo15.SmartCity.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evento")
@Getter @Setter @NoArgsConstructor
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddispositivo")
	private Dispositivo dispositivo;
	
	@Column(name="createdate")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="updatedate")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public Evento(String descripcion, Dispositivo dispositivo) {
		super();
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
	}

}
