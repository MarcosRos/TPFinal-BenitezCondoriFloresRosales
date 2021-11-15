package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Mesa;

public interface IMesaDao {

	public void guardarMesa(Mesa mesa);
	public void borrarMesa(Mesa mesa);
	public List<Mesa> obtenerMesas();
	public void modificarMesa(Mesa mesa);
	public Mesa obtenerMesa(int idMesa);
}
