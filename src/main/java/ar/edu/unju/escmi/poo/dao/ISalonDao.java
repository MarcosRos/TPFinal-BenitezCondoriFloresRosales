package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Salon;

public interface ISalonDao {

	public void guardarSalon(Salon salon);
	public List<Salon> obtenerSalones();
	public void modificarSalon(Salon salon);
	public Salon obtenerSalon(int id);
}
