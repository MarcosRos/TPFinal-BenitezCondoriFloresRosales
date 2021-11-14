package ar.edu.unju.escmi.poo.dominio;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salones")
public class Salon {
	@Id
	private int id;
	private ArrayList <Mesa> mesas;
	
	public Salon() {
		// TODO Auto-generated constructor stub
	}
	
	public Salon(ArrayList<Mesa> mesas) {
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
		return "Salon [id=" + id + ", mesas=" + mesas + "]";
	}

	
	
}
