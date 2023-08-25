package com.grupo15.SmartCity.services;

import java.util.List;

import com.grupo15.SmartCity.entities.Evento;

public interface IEventoService {
	
	public List<Evento> getAll();

	List<Evento> getAllByDispositivoId(int id);
	
	public void registrarEventoSensorHumedad(String lluvia, String porcHumedad, String dispositivo);
	
	public void registrarEventoSensorLuz(String aulaOcupada, String cortinasAbiertas, String dispositivo);
}
