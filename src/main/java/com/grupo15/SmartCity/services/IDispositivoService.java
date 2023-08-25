package com.grupo15.SmartCity.services;

import java.util.List;

import com.grupo15.SmartCity.entities.Dispositivo;

public interface IDispositivoService {
	
	public List<Dispositivo> getAll();
	
	public Dispositivo altaCrear(Dispositivo dispositivo);
	
	public void alta(int id);
	
	public void baja(int id);
	
}
