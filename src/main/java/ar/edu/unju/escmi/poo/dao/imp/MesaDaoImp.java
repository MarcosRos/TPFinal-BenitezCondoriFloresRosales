package ar.edu.unju.escmi.poo.dao.imp;

import javax.persistence.EntityManager;

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

	public void modificarMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(mesa);
		manager.getTransaction().commit();
	}

}
