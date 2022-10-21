package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AnimalDAO {

	private static Connection connection;

	//MODIFICAR UN ANIMAL
	public static void modificarAnimal(Animal animal) {
		try {
		connection = openConnection();
		String query = "update Animales set nombre=?, habitat=?, peso_aproximado=? where id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, animal.getNombre());
			ps.setString(2, animal.getHabitat());
			ps.setFloat(3, animal.getPeso_aproximado());
			ps.setInt(4, animal.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
	
	
	//BUSCAR TODOS LOS ANIMALES
	public static ArrayList<Animal> buscarTodosAnimales(){
		
		connection = openConnection();
		ArrayList<Animal> animales = new ArrayList<Animal>();
		Animal animal = null;
		try {
		String query = "Select * from Animales";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
				animal = new Animal(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"),
						rs.getFloat("peso_aproximado"));
				
				animales.add(animal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return animales;
		
	}
	
	// BUSCAR UN ANIMAL POR ID
	public static Animal buscarAnimalID(int id) {
		Animal animal = null;
		try {
			connection = openConnection();
			String query = "Select * from Animales where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				animal = new Animal(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"),
						rs.getFloat("peso_aproximado"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return animal;
	}

	// BORRAR ANIMAL DADO SU NOMBRE
	public static void deleteAnimalNombre(String nombre) {
		try {
			connection = openConnection();

			String query = "delete from Animales where nombre=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nombre);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	// BORRAR TODOS LOS ANIMALES
	public static void deleteAnimal() {
		try {
			// ABRIR CONEXION
			connection = openConnection();

			// SENTENCIA DE BORRAR
			String query = "delete from animales";
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	// FUNCION PARA INSERTAR ATRIBUTOS EN LA TABLA ANIMAL
	public static void insetAnimal(Animal animal) {
		try {
			// ABRE LA CONEXION
			connection = openConnection();

			// INSERTAMOS LOS DATOS
			String query = "insert into animales(nombre,habitat,peso_aproximado) values (?,?,?)";

			// utilizamos PREPAREDSTATEMENT para meter los valores despues
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setFloat(3, animal.getPeso_aproximado());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CERRAMOS CONEXION
		closeConnection();

	}

	// ABRIR LA CONEXION A LA BASE DE DATOS
	private static Connection openConnection() {

		DataBaseConnection dbconnection = new DataBaseConnection();
		connection = dbconnection.getConnection();
		return connection;
	}

	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
