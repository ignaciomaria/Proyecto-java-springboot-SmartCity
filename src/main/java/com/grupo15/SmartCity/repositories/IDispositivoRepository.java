package com.grupo15.SmartCity.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupo15.SmartCity.entities.Dispositivo;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable>{
	
	public abstract Dispositivo findById(int id);
	
	public abstract Dispositivo findByDescripcion(String descripcion);

	@Transactional
	@Modifying
	@Query("update Dispositivo d set d.activo = true where d.id = :id")
	public abstract void alta(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update Dispositivo d set d.activo = false where d.id = :id")
	public abstract void baja(@Param("id") int id);
}
