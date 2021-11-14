package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IMozoDao;
import ar.edu.unju.escmi.poo.dominio.Mozo;

public class MozoDaoImp implements IMozoDao{

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	public void guardarMozo(Mozo mozo) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(mozo);
		manager.getTransaction().commit();
	}

	public void borrarMozo(Mozo mozo) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(mozo);
		manager.getTransaction().commit();
	}

	public List<Mozo> obtenerMozos() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Mozo> mozos = (List<Mozo>) manager.createQuery("SELECT e FROM Mozo e").getResultList();
		return mozos;
	}

	public void modificarMozo(Mozo mozo) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(mozo);
		manager.getTransaction().commit();	
	}

	public Mozo obtenerMozo(long dniMozo) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT e FROM Mozo e " + "WHERE e.dni = :dniMozo");
		query.setParameter("dniMozo", dniMozo);
		Mozo mozo = (Mozo)query.getSingleResult();
		return mozo;
	}
	
}
