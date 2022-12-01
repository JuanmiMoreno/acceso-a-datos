package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.InterfazDao;
import Dao.ObjetoDao;
import Pojo.Directivo;



public class DirectivoDao extends ObjetoDao implements InterfazDao<Directivo> {

	@Override
	public void insertar(Directivo directivo) {
		connection = openConnection();
		try {
			String query = "insert into directivos (nombre, apellido, dni, correo, empresa_id) values(?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, directivo.getNombre());
			ps.setString(2, directivo.getApellido());
			ps.setString(3, directivo.getDni());
			ps.setString(4, directivo.getCorreo());
			ps.setInt(5, directivo.getEmpresa().getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Directivo directivo) {
		try {
			connection = openConnection();
			String query = "update directivos set nombre=?, apellido=?, dni=?, correo=? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, directivo.getNombre());
			ps.setString(2, directivo.getApellido());
			ps.setString(3, directivo.getDni());
			ps.setString(4, directivo.getCorreo());
			ps.setInt(5, directivo.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	
	
	@Override
	public void borrar(Directivo directivo) {
		try {
			connection = openConnection();

			String query = "delete from directivos where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, directivo.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	
	
	@Override
	public ArrayList<Directivo> buscarTodos() {
		
		connection = openConnection();
		ArrayList<Directivo> directivos = new ArrayList<Directivo>();
		Directivo directivo = null;
		try {
			String query = "Select * from directivos";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				directivo = new Directivo(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),rs.getString(("dni")),
						rs.getString("correo"), null);

				directivos.add(directivo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return directivos;
	
	}

	
	
	

	public void borrarPorEmpresa(int empresaId) {

		connection = openConnection();

		String query = "DELETE  FROM directivos where empresa_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, empresaId);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	@Override
	public Directivo buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
