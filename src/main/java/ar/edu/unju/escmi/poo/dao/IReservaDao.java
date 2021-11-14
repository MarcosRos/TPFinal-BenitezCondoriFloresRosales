package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Reserva;

public interface IReservaDao {

	public void guardarReserva(Reserva reserva);
	public void borrarReserva(Reserva reserva);
	public List<Reserva> obtenerReservas();
	public void modificarReserva(Reserva reserva);
	public Reserva obtenerReserva(int idReserva);
}
