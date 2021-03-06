package ar.edu.unju.escmi.poo.dominio;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class ClienteParticular extends Cliente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String apellido;
	private long dni;

	public ClienteParticular() {
		// TODO Auto-generated constructor stub
	}

	public ClienteParticular(String nombre, String email, long telefono, List<Reserva> reservasHechas,
			String apellido, long dni) {
		super(nombre, email, telefono, reservasHechas);
		this.apellido = apellido;
		this.dni = dni;
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

	@Override
	public String toString() {
		return "ClienteParticular [apellido=" + apellido + ", dni=" + dni + super.toString() + "]";
	}
	
	

	
}
