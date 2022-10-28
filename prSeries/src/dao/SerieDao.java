package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;

import utils.DataBaseConnection;

public class SerieDao implements Dao<Serie> {

	private static Connection connection;

	@Override
	public void insertar(Serie serie) {
		connection = openConnection();
		try {
			String query = "insert into series (titulo,edad,plataforma) values(?,?,?)";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	public SerieDao() {

	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Serie> buscarTodos(Serie t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie buscarPorId(int i) {
		Serie serie = null;
		try {
			connection = openConnection();
			String query = "Select * from series where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getInt("edad"), rs.getString("titulo"),
						rs.getString("plataforma"), null);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return serie;
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
