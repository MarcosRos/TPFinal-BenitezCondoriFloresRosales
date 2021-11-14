package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Cliente;

public interface IClienteDao {

	public void guardarCliente(Cliente cliente);
	public void borrarCliente(Cliente cliente);
	public List<Cliente> obtenerClientes();
	public void modificarCliente(Cliente cliente);
	public Cliente obtenerClienteParticular(long dniCliente);
	public Cliente obtenerClienteAgencia(long cuilCliente);
	public List<Cliente> obtenerClientesAgencia();
	public List<Cliente> obtenerClientesParticular();
}
