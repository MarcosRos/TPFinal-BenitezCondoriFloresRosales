package ar.edu.unju.escmi.poo.dominio;

public class Mesa {

	private int id;
	private String estado;
	private int capacidad;
	
	public Mesa() {
		// TODO Auto-generated constructor stub
	}

	public Mesa(String estado, int capacidad) {
		super();
		this.estado = estado;
		this.capacidad = capacidad;
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

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", estado=" + estado + ", capacidad=" + capacidad + "]";
	}
	
	
	
}
