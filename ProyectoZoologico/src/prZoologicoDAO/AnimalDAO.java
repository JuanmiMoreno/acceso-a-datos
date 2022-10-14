package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AnimalDAO {

	private static Connection connection;

	// FUNCION PARA INSERTAR ATRIBUTOS EN LA TABLA ANIMAL
	public static void insetAnimal(Animal animal) {
		try {
			//ABRE LA CONEXION
			connection = openConnection();
			
			//INSERTAMOS LOS DATOS
			String query = "insert into animales(nombre,habitat,peso_aproximado) values (?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setFloat(3, animal.getPeso_aproximado());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CERRAMOS CONEXION
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
