package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IClienteDao;
import ar.edu.unju.escmi.poo.dominio.Cliente;

public class ClienteDaoImp implements IClienteDao{
	
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

	public void borrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(cliente);
		manager.getTransaction().commit();	
	}

	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = (List<Cliente>) manager.createQuery("SELECT e FROM Cliente e").getResultList();
		return clientes;
	}

	public void modificarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(cliente);
		manager.getTransaction().commit();	
		
	}

	public Cliente obtenerClienteParticular(long dniCliente) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT e FROM ClienteParticular e " + "WHERE e.dni = :dniCliente");
		query.setParameter("dniCliente", dniCliente);
		Cliente cliente = (Cliente)query.getSingleResult();
		return cliente;
	}
	
	public Cliente obtenerClienteAgencia(long cuilCliente) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT e FROM ClienteAgencia e " + "WHERE e.cuil = :cuilCliente");
		query.setParameter("cuilCliente", cuilCliente);
		Cliente cliente = (Cliente)query.getSingleResult();
		return cliente;
	}

	public List<Cliente> obtenerClientesAgencia() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Cliente> clientesAgencia = (List<Cliente>) manager.createQuery("SELECT e FROM ClienteAgencia e").getResultList();
		return clientesAgencia;
	}

	public List<Cliente> obtenerClientesParticular() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Cliente> clientesParticular = (List<Cliente>) manager.createQuery("SELECT e FROM ClienteParticular e").getResultList();
		return clientesParticular;
	}
	
	
}
