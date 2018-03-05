package com.ibm.microempresa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ibm.microempresa.model.Solicitud;

/**
 * DAO implementation interface
 * @author kristian
 *
 */

@Repository
public class SolicitudDAOImpl implements SolicitudDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SolicitudDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addSolicitud(Solicitud solicitud) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(solicitud);
		logger.info("Solicitud guardada exitosamente, Solicitud Details="+solicitud);
	}

	@Override
	public void updateSolicitud(Solicitud solicitud) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(solicitud);
		logger.info("Solicitud actualizada exitosamente, Solicitud Details="+solicitud);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> listSolicitudes(String tipoDocumento, Integer documento) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Solicitud s where s.tipoDocumento = :tipoDocumento and s.numeroDocumento = :documento";
		Query query = session.createQuery(hql);
		query.setParameter("tipoDocumento", tipoDocumento);
		query.setParameter("documento",documento);
		logger.info("Solicitudes obtenidas exitosamente");
		return (List<Solicitud>)query.list();
	}

	@Override
	public Solicitud getSolicitudById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Solicitud solicitud = (Solicitud) session.load(Solicitud.class, new Integer(id));
		logger.info("Solicitud obtenida exitosamente, Solicitud details="+solicitud);
		return solicitud;
	}

	@Override
	public void removeSolicitud(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Solicitud solicitud = (Solicitud) session.load(Solicitud.class, new Integer(id));
		if(null != solicitud){
			session.delete(solicitud);
		}
		logger.info("Solicitud eliminada exitosamente, Solicitud details="+solicitud);
	}

}
