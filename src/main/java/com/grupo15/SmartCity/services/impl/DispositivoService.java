package com.grupo15.SmartCity.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo15.SmartCity.entities.Dispositivo;
import com.grupo15.SmartCity.repositories.IDispositivoRepository;
import com.grupo15.SmartCity.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService{
		
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;
	
	@Override
	public List<Dispositivo> getAll() {
		// TODO Auto-generated method stub
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo altaCrear(Dispositivo dispositivo) {
		// TODO Auto-generated method stub
		dispositivo.setActivo(true);
		Dispositivo nuevo = dispositivoRepository.save(dispositivo);
		return nuevo;
	}

	@Override
	public void baja(int id) {
		// TODO Auto-generated method stub
		dispositivoRepository.baja(id);
	}

	@Override
	public void alta(int id) {
		// TODO Auto-generated method stub
		dispositivoRepository.alta(id);
	}

}
