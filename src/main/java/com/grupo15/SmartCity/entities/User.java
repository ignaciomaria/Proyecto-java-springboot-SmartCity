package com.grupo15.SmartCity.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter @Setter @NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="enable")
	private boolean enable;
	
	@Column(name="createdate")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="updatedate")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public User(String userName, String password, String role, boolean enable, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.enable = enable;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
