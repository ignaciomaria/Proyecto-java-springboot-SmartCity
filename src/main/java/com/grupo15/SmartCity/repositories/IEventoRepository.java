package com.grupo15.SmartCity.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo15.SmartCity.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable>{
	
	public abstract List<Evento> findAllByDispositivoId(int id);
}
