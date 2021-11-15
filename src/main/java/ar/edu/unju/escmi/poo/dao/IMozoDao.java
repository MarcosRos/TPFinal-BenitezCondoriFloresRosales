package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Mozo;

public interface IMozoDao {

	public void guardarMozo(Mozo mozo);
	public void borrarMozo(Mozo mozo);
	public List<Mozo> obtenerMozos();
	public void modificarMozo(Mozo mozo);
	public Mozo obtenerMozo(long dniMozo);
	public Mozo obtenerMozoId(int idMozo);
}
