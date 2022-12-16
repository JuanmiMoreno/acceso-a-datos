package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.InterfazDao;
import Dao.ObjetoDao;
import Pojo.Directivo;
import Pojo.Empresa;
/**
 * Clase con las funciones para insertar, modificar y consultar en la base de datos
 * @author Juanmi
 *
 */
public class DirectivoDao extends ObjetoDao implements InterfazDao<Directivo> {

	/**
	 * Funcion que sirve para insertar un directivo en la base de datos, muestra un error si no
	 * se puede insertar 
	 */
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

	/**
	 * Funcion que sirve para modificar un dato en la base de datos, si no puede modificar 
	 * muestra un error
	 */
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

	/**
	 * Funcion que sirve para borrar un dato de la tabla, si no funciona muestra un error
	 */
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
	/**
	 * Funcion que sirve para mostrar todos los directivos que haya en la tabla directivos. 
	 * Si no funciona muestra un error
	 * @return devuelve un arraylist con todos los directivos
	 */
	public ArrayList<Directivo> buscarTodos() {

		connection = openConnection();
		ArrayList<Directivo> directivos = new ArrayList<Directivo>();
		Directivo directivo = null;
		try {
			String query = "Select * from directivos";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				directivo = new Directivo(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString(("dni")), rs.getString("correo"));

				directivos.add(directivo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return directivos;

	}

	@Override
	/**
	 * Funcion que busca un directivo segun id
	 * @param id. es el id del directivo que busca
	 * @return devuelve el directivo con el id buscado
	 */
	public Directivo buscarPorId(int id) {
		Directivo directivo = null;
		try {
			connection = openConnection();
			String query = "Select * from directivos where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				directivo = new Directivo(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("dni"), rs.getString("correo"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return directivo;
	}
	
	/**
	 * Funcion que busca los directivos con apellidos = a marin
	 * @return devuelve un arraylist con los directivos que tienen el apellido marin
	 */
	public ArrayList<Directivo> buscarPorApellido() {

		connection = openConnection();
		ArrayList<Directivo> directivos = new ArrayList<Directivo>();
		Directivo directivo = null;
		try {
			String query = "Select * from directivos where apellido=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, "Marin");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				directivo = new Directivo(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString(("dni")), rs.getString("correo"));

				directivos.add(directivo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return directivos;
	}

	/**
	 * Funcion que borra el directivo con el id de la emprsa
	 * @param empresaId id de la empresa a la que pertenece
	 */
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

	/**
	 * Funcion que resetea el auto incremet a 1
	 */
	public void resetAutoIncrement() {
		try {
			connection = openConnection();
			String query = "alter table  directivos AUTO_INCREMENT=1;";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}
}
