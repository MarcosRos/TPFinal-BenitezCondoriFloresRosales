package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="mozos")
public class Mozo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	private String apellido;
	private long dni;
	private ArrayList <Reserva> reservasAtendidas; 
	
	public Mozo() {
		// TODO Auto-generated constructor stub
	}

	public Mozo(String nombre, String apellido, long dni, ArrayList<Reserva> reservasAtendidas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.reservasAtendidas = reservasAtendidas;
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

	public ArrayList<Reserva> getReservasAtendidas() {
		return reservasAtendidas;
	}

	public void setReservasAtendidas(ArrayList<Reserva> reservasAtendidas) {
		this.reservasAtendidas = reservasAtendidas;
	}

	@Override
	public String toString() {
		return "Mozo [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", reservasAtendidas="
				+ reservasAtendidas + "]";
	}

	
	
	
	
}
