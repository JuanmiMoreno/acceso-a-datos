package pojo;

public class Temporada {

	private int id;
	private int num_temporadas;
	private String titulo;
	private Serie serie;
	
	
	public Temporada(int num_temporadas, String titulo, Serie serie) {
		super();
		this.num_temporadas = num_temporadas;
		this.titulo = titulo;
		this.serie = serie;
	}


	public Temporada(int id, int num_temporadas, String titulo, Serie serie) {
		super();
		this.id = id;
		this.num_temporadas = num_temporadas;
		this.titulo = titulo;
		this.serie = serie;
	}
	
	public Temporada(int id, int num_temporadas, String titulo) {
		super();
		this.id = id;
		this.num_temporadas = num_temporadas;
		this.titulo = titulo;
	
	}


	public int getNum_temporadas() {
		return num_temporadas;
	}


	public void setNum_temporadas(int num_temporadas) {
		this.num_temporadas = num_temporadas;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Serie getSerie() {
		return serie;
	}


	public void setSerie(Serie serie) {
		this.serie = serie;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Temporada [id=" + id + ", num_temporadas=" + num_temporadas + ", titulo=" + titulo + ",  titulo serie=" + serie.getTitulo()
				+ "]";
	}
	
	
}
