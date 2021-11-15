package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.ISalonDao;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class SalonDaoImp implements ISalonDao{

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	public void guardarSalon(Salon salon) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(salon);
		manager.getTransaction().commit();
	}

	public List<Salon> obtenerSalones() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Salon> salones = (List<Salon>) manager.createQuery("SELECT e FROM Salon e").getResultList();
		return salones;
	}

	public void modificarSalon(Salon salon) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(salon);
		manager.getTransaction().commit();	
	}

	public Salon obtenerSalon(int idSalon) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT e FROM Salon e " + "WHERE e.id = :idSalon");
		query.setParameter("idSalon",idSalon );
		Salon salon = (Salon)query.getSingleResult();
		return salon;
	}

}
