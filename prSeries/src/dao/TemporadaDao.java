package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;
import utils.DataBaseConnection;

public class TemporadaDao implements Dao<Temporada> {

	private static Connection connection;
	
	
	@Override
	public void insertar(Temporada t) {
		connection = openConnection();
		try {
			String query = "insert into temporadas (num_temporada, titulo, serie_id) values(?,?,?)";

			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, t.getNum_temporadas());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}
		
	

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Temporada> buscarTodos(Temporada t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
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
