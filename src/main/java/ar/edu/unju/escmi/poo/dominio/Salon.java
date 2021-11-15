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
@Table(name="salones")
public class Salon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private int id;
	@OneToMany(mappedBy="salon")
	private List <Mesa> mesas;
	
	public Salon() {
		// TODO Auto-generated constructor stub
	}
	
	public Salon(List<Mesa> mesas) {
		super();
		this.mesas = mesas;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Mesa> getMesas() {
		return mesas;
	}
	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		return "Salon [id=" + id + ", mesas=" + mesas + "]";
	}

	
	
}
