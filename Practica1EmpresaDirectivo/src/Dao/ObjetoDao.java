package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import Utils.DataBaseConnection;
/**
 * Funcion que sirve para abrir y cerrar la conexion con la base de datos
 * @author Juanmi
 *
 */
public class ObjetoDao {

	protected static Connection connection;
	
	protected static Connection openConnection() {

		DataBaseConnection dbconnection = new DataBaseConnection();
		connection = dbconnection.getConnection();
		return connection;
	}

	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
