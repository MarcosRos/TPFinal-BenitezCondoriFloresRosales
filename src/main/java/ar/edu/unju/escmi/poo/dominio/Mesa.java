package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="mesas")
public class Mesa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String estado;
	private int capacidad;
	@ManyToOne
	@JoinColumn (name="salon_id")
	private Salon salon;
	
	public Mesa() {
		// TODO Auto-generated constructor stub
	}

	public Mesa(String estado, int capacidad, Salon salon) {
		super();
		this.estado = estado;
		this.capacidad = capacidad;
		this.salon = salon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", estado=" + estado + ", capacidad=" + capacidad + " asientos libres de 4 totales]";
	}
	
	
	
}
