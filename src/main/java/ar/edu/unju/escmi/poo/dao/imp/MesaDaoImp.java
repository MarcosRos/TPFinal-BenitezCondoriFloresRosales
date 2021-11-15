package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IMesaDao;
import ar.edu.unju.escmi.poo.dominio.Mesa;

public class MesaDaoImp implements IMesaDao {
	
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	public void guardarMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(mesa);
		manager.getTransaction().commit();
	}

	public void borrarMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(mesa);
		manager.getTransaction().commit();
	}

	public List<Mesa> obtenerMesas() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Mesa> mesas = (List<Mesa>) manager.createQuery("SELECT e FROM Mesa e").getResultList();
		return mesas;
	}

	public void modificarMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(mesa);
		manager.getTransaction().commit();
	}

	public Mesa obtenerMesa(int idMesa) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT e FROM Mozo e " + "WHERE e.id = :idMesa");
		query.setParameter("idMesa", idMesa);
		Mesa mesa = (Mesa)query.getSingleResult();
		return mesa;
	}

}
