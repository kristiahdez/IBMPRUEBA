package com.ibm.microempresa.dao;

import java.util.List;

import com.ibm.microempresa.model.Solicitud;;

/**
 * DAO interface
 * @author kristian
 *
 */
public interface SolicitudDAO {

	public void addSolicitud(Solicitud solicitud);
	public void updateSolicitud(Solicitud solicitud);
	public List<Solicitud> listSolicitudes(String tipoDocumento, Integer Documento);
	public Solicitud getSolicitudById(int id);
	public void removeSolicitud(int id);
	
}
