package com.grupo15.SmartCity.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo15.SmartCity.entities.Evento;
import com.grupo15.SmartCity.repositories.IDispositivoRepository;
import com.grupo15.SmartCity.repositories.IEventoRepository;
import com.grupo15.SmartCity.services.IEventoService;

@Service("eventoService")
public class EventoService implements IEventoService{
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;

	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;
	
	@Override
	public List<Evento> getAll() {
		// TODO Auto-generated method stub
		return eventoRepository.findAll();
	}
	
	@Override
	public List<Evento> getAllByDispositivoId(int id) {
		// TODO Auto-generated method stub
		return eventoRepository.findAllByDispositivoId(id);
	}

	@Override
	public void registrarEventoSensorHumedad(String lluvia, String porcHumedad, String dispositivo) {
		// TODO Auto-generated method stub
		Evento evento = null;
		if(dispositivoRepository.findByDescripcion(dispositivo).isActivo()) {
			if(lluvia.equalsIgnoreCase("No") && Integer.parseInt(porcHumedad)<30) {
				evento = new Evento("Se encienden aspersores", dispositivoRepository.findByDescripcion(dispositivo));
				eventoRepository.save(evento);
			}
		}
	}
	
	@Override
	public void registrarEventoSensorLuz(String aulaOcupada, String cortinasAbiertas, String dispositivo) {
		// TODO Auto-generated method stub
		Evento evento = null;
		if(dispositivoRepository.findByDescripcion(dispositivo).isActivo()) {
			if(aulaOcupada.equalsIgnoreCase("Si") && cortinasAbiertas.equalsIgnoreCase("Si")) {
				evento = new Evento("Se encienden las luces", dispositivoRepository.findByDescripcion(dispositivo));
				eventoRepository.save(evento);
			}
		}
	}
}
