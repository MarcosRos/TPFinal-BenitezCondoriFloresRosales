package ar.edu.unju.escmi.poo.dominio;

import java.util.ArrayList;

public class Mozo {
	private int id;
	private String nombre;
	private String apellido;
	private long dni;
	private ArrayList <Mesa> mesasAtendidas; 
	
	public Mozo() {
		// TODO Auto-generated constructor stub
	}

	public Mozo(String nombre, String apellido, long dni, ArrayList<Mesa> mesasAtendidas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mesasAtendidas = mesasAtendidas;
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

	public ArrayList<Mesa> getMesasAtendidas() {
		return mesasAtendidas;
	}

	public void setMesasAtendidas(ArrayList<Mesa> mesasAtendidas) {
		this.mesasAtendidas = mesasAtendidas;
	}

	@Override
	public String toString() {
		return "Mozo [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", mesasAtendidas="
				+ mesasAtendidas + "]";
	}
	
	
	
}
