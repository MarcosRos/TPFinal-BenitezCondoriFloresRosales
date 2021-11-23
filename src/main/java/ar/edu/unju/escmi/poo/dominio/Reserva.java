package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="reservas")
public class Reserva implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private int id;
	@Column (length = 9999999)
	private Cliente clienteReserva;
	@Column (length = 9999999)
	private Mozo mozoAtendiendo;
	@Column (length = 9999999)
	private ArrayList<Mesa> mesasOcupadas;
	private int idSalonUsado;
	private LocalDate fecha;
	private LocalTime hora;
	private double totalAPagar;
	private String estado;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(Cliente clienteReserva, Mozo mozoAtendiendo, ArrayList<Mesa> mesasOcupadas, int idSalonUsado,
			LocalDate fecha, LocalTime hora, double totalAPagar, String estado) {
		super();
		this.clienteReserva = clienteReserva;
		this.mozoAtendiendo = mozoAtendiendo;
		this.mesasOcupadas = mesasOcupadas;
		this.idSalonUsado = idSalonUsado;
		this.fecha = fecha;
		this.hora = hora;
		this.totalAPagar = totalAPagar;
		this.estado = estado;
	}
	
	public Reserva crearReserva(Cliente unCliente, Mozo unMozo,ArrayList<Mesa>mesasOcupadas, int salonElegido, double totalAPagar) {
		Reserva reservaCreada=new Reserva(unCliente, unMozo, mesasOcupadas, salonElegido, LocalDate.now(),
				LocalTime.now(), totalAPagar, "Sin Pagar");
		return reservaCreada;
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

	public int getIdSalonUsado() {
		return idSalonUsado;
	}

	public void setSalonUsado(int idSalonUsado) {
		this.idSalonUsado = idSalonUsado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
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

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", clienteReserva=" + clienteReserva + ", IdDelMozoAtendiendo=" + mozoAtendiendo.getId()
				+ ", mesasOcupadas=" + mesasOcupadas + ", idSalonUsado=" + idSalonUsado + ", fecha=" + fecha + ", hora="
				+ hora + ", totalAPagar=" + totalAPagar + ", estado=" + estado + "]";
	}
	
	
	
}
