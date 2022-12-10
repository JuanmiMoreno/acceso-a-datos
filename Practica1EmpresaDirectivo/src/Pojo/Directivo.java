package Pojo;

public class Directivo {

	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private Empresa empresa;
	
	
	
	
	
	
	public Directivo(String nombre, String apellido, String dni, String correo, Empresa empresa) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.empresa = empresa;
	}


	public Directivo(int id, String nombre, String apellido, String dni, String correo, Empresa empresa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.empresa = empresa;
	}
	
	public Directivo(int id, String nombre, String apellido, String dni, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Nombre: "+this.nombre+"\n"+
				"Apellido: "+this.apellido+"\n"+
				"DNI: "+this.dni+"\n"+
				"Correo: "+this.correo+"\n";
				//"Nombre de la empresa: "+this.empresa.getNombre()+"\n";
	}
	
	
	
	
	
	
}
