package com.grupo15.SmartCity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo15.SmartCity.entities.SensorHumedad;
import com.grupo15.SmartCity.entities.SensorLuz;
import com.grupo15.SmartCity.helpers.ViewRouteHelper;
import com.grupo15.SmartCity.services.IDispositivoService;

@Controller
@RequestMapping("/dispositivos")
public class DispositivoController {

	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@GetMapping("/crear-sensor-humedad")
	public ModelAndView crearSensorHumedad() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ALTASENSORHUMEDAD);
		mAV.addObject("sensorhumedad", new SensorHumedad());
		return mAV;
	}
	
	@GetMapping("/crear-sensor-luz")
	public ModelAndView crearSensorLuz() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ALTASENSORLUZ);
		mAV.addObject("sensorluz", new SensorLuz());
		return mAV;
	}
	
	@PostMapping("/alta-sensor-humedad")
	public RedirectView altaSensorHumedad(@ModelAttribute("sensorhumedad") SensorHumedad sensorHumedad) {
		dispositivoService.altaCrear(sensorHumedad);
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	@PostMapping("/alta-sensor-luz")
	public RedirectView altaSensorLuz(@ModelAttribute("sensorluz") SensorLuz sensorLuz) {
		dispositivoService.altaCrear(sensorLuz);
		return new RedirectView(ViewRouteHelper.HOME);
	}
	
	@GetMapping("/listado-dispositivos")
	public ModelAndView listadoDispositivos() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LISTADODISPOSITIVOS);
		mAV.addObject("dispositivosLista", dispositivoService.getAll());
		return mAV;
	}
	
	@PostMapping("/alta/{id}")
	public RedirectView alta(@PathVariable int id) {
		dispositivoService.alta(id);
		return new RedirectView(ViewRouteHelper.REDIRECTLISTADODISPOSITIVOS);
	}
	
	@PostMapping("/baja/{id}")
	public RedirectView baja(@PathVariable int id) {
		dispositivoService.baja(id);
		return new RedirectView(ViewRouteHelper.REDIRECTLISTADODISPOSITIVOS);
	}
}
