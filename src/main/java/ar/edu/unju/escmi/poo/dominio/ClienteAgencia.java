package ar.edu.unju.escmi.poo.dominio;

import javax.persistence.Entity;

@Entity
public class ClienteAgencia extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long cuit;
	
	public ClienteAgencia() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteAgencia(String nombre, String email, long telefono, long cuit) {
		super(nombre, email, telefono);
		this.cuit = cuit;
	}
	
	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	@Override
	public String toString() {
		return "ClienteAgencia [cuit=" + cuit + super.toString() + "]";
	}

	
	
}
