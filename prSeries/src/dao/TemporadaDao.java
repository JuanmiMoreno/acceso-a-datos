package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Temporada;
import utils.DataBaseConnection;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada> {

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
		try {
			
			connection = openConnection();

			
			String query = "delete from temporadas where id=?";

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
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
