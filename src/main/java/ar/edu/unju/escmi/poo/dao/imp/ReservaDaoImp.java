package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IReservaDao;
import ar.edu.unju.escmi.poo.dominio.Reserva;

public class ReservaDaoImp implements IReservaDao {
	
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	public void guardarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(reserva);
		manager.getTransaction().commit();
	}

	public void borrarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(reserva);
		manager.getTransaction().commit();
		
	}

	public List<Reserva> obtenerReservas() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Reserva> reserva= (List<Reserva>) manager.createQuery("SELECT e FROM Reserva e").getResultList();
		return reserva;
	}

	public void modificarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(reserva);
		manager.getTransaction().commit();	
		
	}

	public Reserva obtenerReserva(int idReserva) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT e FROM Reserva e " + "WHERE e.id = :idReserva");
		query.setParameter("idReserva", idReserva);
		Reserva reserva = (Reserva)query.getSingleResult();
		return reserva;
	}

}
