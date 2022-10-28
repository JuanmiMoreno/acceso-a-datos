package pojo;

import java.util.ArrayList;

public class Serie {

	private int id;
	private int edad;
	private String titulo;
	private String plataforma;
	private ArrayList<Temporada> temporadas;
	
	
	public Serie(int edad, String titulo, String plataforma) {
		super();
		this.edad = edad;
		this.titulo = titulo;
		this.plataforma = plataforma;
	}


	public Serie(int id, int edad, String titulo, String plataforma, ArrayList<Temporada> temporadas) {
		super();
		this.id = id;
		this.edad = edad;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.temporadas = temporadas;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}


	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}


	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Serie [id=" + id + ", edad=" + edad + ", titulo=" + titulo + ", plataforma=" + plataforma + "]";
	}
	
	
	
	
}
