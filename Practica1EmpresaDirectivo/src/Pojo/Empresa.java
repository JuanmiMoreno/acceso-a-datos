package Pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class Empresa {

	private int id;
	private String nombre;
	private String cif;
	private float presupuesto;
	private ArrayList<Directivo> totalDirectivos;
	
	public Empresa(String nombre, String cif, float presupuesto) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.presupuesto = presupuesto;
		
		
	}


	public Empresa(int id, String nombre, String cif, float presupuesto, ArrayList<Directivo> totalDirectivos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cif = cif;
		this.presupuesto = presupuesto;
		this.totalDirectivos = totalDirectivos;
	}


	public ArrayList<Directivo> getTotalDirectivos() {
		return totalDirectivos;
	}


	public void setTotalDirectivos(ArrayList<Directivo> totalDirectivos) {
		this.totalDirectivos = totalDirectivos;
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


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}


	public float getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}


	@Override
	public String toString() {
		return "Empresa: "+ this.getNombre()+"\n\tID: "+this.id+"\n\tCIF: "+this.cif+"\n\tPresupuesto: "+this.presupuesto;
	}
	
	
	
	
}
