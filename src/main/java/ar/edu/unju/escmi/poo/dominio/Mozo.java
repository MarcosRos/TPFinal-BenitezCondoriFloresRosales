package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="mozos")
public class Mozo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="dni")
	private long dni;
	@Column(length = 9999999)
	@OneToMany
	private List <Reserva> reservasAtendidas; 
	
	public Mozo() {
		// TODO Auto-generated constructor stub
	}

	public Mozo(String nombre, String apellido, long dni, List<Reserva> reservasAtendidas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.reservasAtendidas = reservasAtendidas;
	}
	
	public Mozo asignarReservas(Mozo unMozo,List<Reserva>reservasAAtender) {
		unMozo.setReservasAtendidas(reservasAAtender);
		return unMozo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public List<Reserva> getReservasAtendidas() {
		return reservasAtendidas;
	}

	public void setReservasAtendidas(List<Reserva> reservasAtendidas) {
		this.reservasAtendidas = reservasAtendidas;
	}

	@Override
	public String toString() {
		return "Mozo [id="+ id +", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", reservasAtendidas="
				+ reservasAtendidas + "]";
	}

	
	
	
	
}
