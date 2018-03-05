package com.ibm.microempresa.service;

import java.util.List;

import com.ibm.microempresa.model.Solicitud;

/**
 * Service interface
 * @author kristian
 *
 */
public interface SolicitudService {

	public void addSolicitud(Solicitud solitidud);
	public void updateSolicitud(Solicitud solitidud);
	public List<Solicitud> listSolicitudes(String tipoDocumento, Integer documento);
	public Solicitud getSolicitudById(int id);
	public void removeSolicitud(int id);
	
}
