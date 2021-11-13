package ar.edu.unju.escmi.poo.dominio;

import java.util.ArrayList;

public class Sala {
	
	private int id;
	private ArrayList <Mesa> mesas;
	
	public Sala() {
		// TODO Auto-generated constructor stub
	}
	
	public Sala(ArrayList<Mesa> mesas) {
		super();
		this.mesas = mesas;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}
	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		return "Sala [mesas=" + mesas + "]";
	}
	
}
