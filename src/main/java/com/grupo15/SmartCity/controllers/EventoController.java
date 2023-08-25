package com.grupo15.SmartCity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo15.SmartCity.helpers.ViewRouteHelper;
import com.grupo15.SmartCity.services.IEventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	@GetMapping("/registrar-humedad")
	public ModelAndView registrarHumedad() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REGISTRAREVENTOHUMEDAD);
		return mAV;
	}
	
	@GetMapping("/registrar-luz")
	public ModelAndView registrarLuz() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REGISTRAREVENTOLUZ);
		return mAV;
	}
	
	@GetMapping("/registrar-evento-humedad")
	public RedirectView registrarEventoHumedad(@RequestParam(value = "lluvia") String lluvia, 
												@RequestParam(value = "porcentajeHumedad") String porcHumedad, 
												@RequestParam(value = "dispositivo") String dispositivo) {
		RedirectView rV = new RedirectView(ViewRouteHelper.REDIRECTLISTADOEVENTOS);
		eventoService.registrarEventoSensorHumedad(lluvia, porcHumedad, dispositivo);
		return rV;
	}
	
	@GetMapping("/registrar-evento-luz")
	public RedirectView registrarEventoLuz(@RequestParam(value = "aulaOcupada") String aulaOcupada, 
												@RequestParam(value = "cortinasAbiertas") String cortinasAbiertas, 
												@RequestParam(value = "dispositivo") String dispositivo) {
		RedirectView rV = new RedirectView(ViewRouteHelper.REDIRECTLISTADOEVENTOS);
		eventoService.registrarEventoSensorLuz(aulaOcupada, cortinasAbiertas, dispositivo);
		return rV;
	}
	
	@GetMapping("/listado-eventos")
	public ModelAndView listadoEventos() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LISTADOEVENTOS);
		mAV.addObject("eventosLista", eventoService.getAll());
		return mAV;
	}
	
	@PostMapping("/listado-eventos/{id}")
	public ModelAndView listadoEventosPorId(@PathVariable int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LISTADOEVENTOS);
		mAV.addObject("eventosLista", eventoService.getAllByDispositivoId(id));
		return mAV;
	}
}
