package com.ibm.microempresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.microempresa.model.Producto;
import com.ibm.microempresa.model.Solicitud;
import com.ibm.microempresa.service.SolicitudService;

/**
 * controller with Spring annotations
 * @author kristian
 *
 */
@RestController
public class SolicitudController {
	
	private SolicitudService solicitudService;
	
	@Autowired(required=true)
	@Qualifier(value="solicitudService")
	public void setSolicitudService(SolicitudService ss){
		this.solicitudService = ss;
	}
	
	@RequestMapping(value = "/solicitudes", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Solicitud>> listSolicitudes(@RequestParam(value="tipoDocumenti", required=true) String tipoDocumento,
	        @RequestParam(value="documento", required=true) Integer documento) {
		List<Solicitud> listSolicitudes = new ArrayList<Solicitud>();  
		for(Solicitud solicitud : this.solicitudService.listSolicitudes(tipoDocumento, documento)) {
			listSolicitudes.add(solicitud);
		}
		return new ResponseEntity<List<Solicitud>>(listSolicitudes, HttpStatus.OK);	
	}
	
	//For add and update person both
	@RequestMapping(value= "/solicitud/add", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Solicitud> addSolicitud(@RequestBody Solicitud solicitud){
		if(validarCantidadProductos(solicitud)) {
			this.solicitudService.addSolicitud(solicitud);
			return new ResponseEntity<Solicitud>(solicitud, HttpStatus.CREATED);
		}else {
			solicitud.setRespuestaPeticion("Solo puede seleccionar maximo 5 prendas");
			return new ResponseEntity<Solicitud>(solicitud, HttpStatus.BAD_REQUEST);
		}
	}
	
	public boolean validarCantidadProductos(Solicitud solicitud) {
		if (solicitud.getProductos() != null && solicitud.getProductos().size() > 5 ) {
			return true;
		}else{
			int i = 0;
			for(Producto producto : solicitud.getProductos()) {
				i = i + producto.getCantidad();
			}
			if(i > 5) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping("/solicitud/remove/{id}")
    public @ResponseBody ResponseEntity<Solicitud> removePersona(@PathVariable("id") int id){
		this.solicitudService.removeSolicitud(id);
        return new ResponseEntity<Solicitud>(HttpStatus.OK);
    }
 
    @RequestMapping("/solicitud/edit/{id}")
    public @ResponseBody ResponseEntity<Solicitud> editSolicitud(@RequestBody Solicitud solicitud){
    	if(validarCantidadProductos(solicitud)) {
    		this.solicitudService.updateSolicitud(solicitud);
    		return  new ResponseEntity<Solicitud>(HttpStatus.OK);
		}else {
			solicitud.setRespuestaPeticion("Solo puede seleccionar maximo 5 prendas");
			return new ResponseEntity<Solicitud>(solicitud, HttpStatus.BAD_REQUEST);
		}
	}
    
    @RequestMapping("/solicitud/go")
    public String crearSolicitud(){
		return "solicitud";
    }
	
}
