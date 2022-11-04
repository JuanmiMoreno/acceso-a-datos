package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import utils.DataBaseConnection;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {

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
		try {
			connection = openConnection();
			String query = "update series set titulo=?, edad=?, plataforma=? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getTitulo());
			ps.setInt(2, t.getEdad());
			ps.setString(3, t.getPlataforma());
			ps.setInt(4, t.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	public ArrayList<Temporada> obetenerTemporadas(Serie serie) {
		ArrayList<Temporada> temporadas = new ArrayList<>();
		try {
			
			connection = openConnection();

			String query = "select * from temporadas where serie_id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Temporada temporada = new Temporada(rs.getInt("id"), rs.getInt("num_temporada"), rs.getString("titulo"),
						serie);
				
				temporadas.add(temporada);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		
		return temporadas;
	}

	@Override
	public void borrar(Serie t) {

		ArrayList<Temporada> temporadas = obetenerTemporadas(t);
		TemporadaDao tD = new TemporadaDao();
		for(Temporada temporada : temporadas) {
		
			tD.borrar(temporada);
			
		}
		try {
		connection = openConnection();

		
		String query = "delete from series where id=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, t.getId());
		ps.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	closeConnection();

		
		
		
	}

	@Override
	public ArrayList<Serie> buscarTodos() {

		connection = openConnection();
		ArrayList<Serie> series = new ArrayList<Serie>();
		Serie serie = null;
		try {
			String query = "Select * from series";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getInt("edad"), rs.getString("titulo"),
						rs.getString("plataforma"), null);

				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return series;
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

}
