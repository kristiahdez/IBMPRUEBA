package com.ibm.microempresa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.microempresa.dao.SolicitudDAO;
import com.ibm.microempresa.model.Solicitud;
/**
 * Service implementation
 * @author kristian
 *
 */
@Service
public class SolicitudServiceImpl implements SolicitudService {
	
	private SolicitudDAO solicitudDAO;

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	@Override
	@Transactional
	public void addSolicitud(Solicitud solicitud) {
		this.solicitudDAO.addSolicitud(solicitud);
	}

	@Override
	@Transactional
	public void updateSolicitud(Solicitud solicitud) {
		this.solicitudDAO.updateSolicitud(solicitud);
	}

	@Override
	@Transactional
	public List<Solicitud> listSolicitudes(String tipoDocumento, Integer documento) {
		return this.solicitudDAO.listSolicitudes(tipoDocumento, documento);
	}

	@Override
	@Transactional
	public Solicitud getSolicitudById(int id) {
		return this.solicitudDAO.getSolicitudById(id);
	}

	@Override
	@Transactional
	public void removeSolicitud(int id) {
		this.solicitudDAO.removeSolicitud(id);
	}

}
