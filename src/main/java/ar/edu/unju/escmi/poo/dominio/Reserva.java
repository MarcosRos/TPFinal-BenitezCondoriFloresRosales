package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="reservas")
public class Reserva implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private Cliente clienteReserva;
	private Mozo mozoAtendiendo;
	
	@OneToMany(mappedBy="mesa")
	private ArrayList<Mesa> mesasOcupadas;
	private Salon salonUsado;
	private LocalDate fecha;
	private LocalDateTime hora;
	private double totalAPagar;
	private String estado;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(Cliente clienteReserva, Mozo mozoAtendiendo, ArrayList<Mesa> mesasOcupadas, Salon salonUsado,
			LocalDate fecha, LocalDateTime hora, double totalAPagar, String estado) {
		super();
		this.clienteReserva = clienteReserva;
		this.mozoAtendiendo = mozoAtendiendo;
		this.mesasOcupadas = mesasOcupadas;
		this.salonUsado = salonUsado;
		this.fecha = fecha;
		this.hora = hora;
		this.totalAPagar = totalAPagar;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getClienteReserva() {
		return clienteReserva;
	}

	public void setClienteReserva(Cliente clienteReserva) {
		this.clienteReserva = clienteReserva;
	}

	public Mozo getMozoAtendiendo() {
		return mozoAtendiendo;
	}

	public void setMozoAtendiendo(Mozo mozoAtendiendo) {
		this.mozoAtendiendo = mozoAtendiendo;
	}

	public ArrayList<Mesa> getMesasOcupadas() {
		return mesasOcupadas;
	}

	public void setMesasOcupadas(ArrayList<Mesa> mesasOcupadas) {
		this.mesasOcupadas = mesasOcupadas;
	}

	public Salon getSalonUsado() {
		return salonUsado;
	}

	public void setSalonUsado(Salon salonUsado) {
		this.salonUsado = salonUsado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public double getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
