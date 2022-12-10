package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Directivo;
import Pojo.Empresa;







public class EmpresaDao extends ObjetoDao implements InterfazDao<Empresa> {

	@Override
	public void insertar(Empresa empresa) {
		connection = openConnection();
		try {
			String query = "insert into empresas (nombre,cif,presupuesto) values(?,?,?)";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, empresa.getNombre());
			ps.setString(2, empresa.getCif());
			ps.setFloat(3, empresa.getPresupuesto());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Empresa empresa) {
		try {
			connection = openConnection();
			String query = "update empresas set nombre=?, cif=?, presupuesto=? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, empresa.getNombre());
			ps.setString(2, empresa.getCif());
			ps.setFloat(3, empresa.getPresupuesto());
			ps.setInt(4, empresa.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}
	

	@Override
	public void borrar(Empresa empresa) {
		try {
			DirectivoDao directivoDao = new DirectivoDao();
			directivoDao.borrarPorEmpresa(empresa.getId());
		
			connection = openConnection();
			String query = "delete from empresas where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, empresa.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	
	
	@Override
	public ArrayList<Empresa> buscarTodos() {
		connection = openConnection();
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;
		try {
			String query = "Select * from empresas";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList<Directivo> directivos = new ArrayList<Directivo>();
				
				empresa = new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("cif"),
						rs.getFloat("presupuesto"), null);
				
				String queryDirectivo ="select * from directivos where empresa_id = ?";
				PreparedStatement psDirectivo = connection.prepareStatement(queryDirectivo);
				psDirectivo.setInt(1, rs.getInt("id"));
				ResultSet rsDirectivo = psDirectivo.executeQuery();
				
				while(rsDirectivo.next()) {
					Directivo directivo = new Directivo(rsDirectivo .getInt("id"),rsDirectivo .getString("nombre"),
							rsDirectivo .getString("apellido"), rsDirectivo.getString("dni"),rsDirectivo.getString("correo") );
				
					directivos.add(directivo);
				}
				
				empresa.setTotalDirectivos(directivos);
				empresas.add(empresa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return empresas;
	}
	
	
	
	public ArrayList<Directivo> obetenerDirectivos(Empresa empresa) {
		ArrayList<Directivo> directivos = new ArrayList<>();
		try {

			connection = openConnection();

			String query = "select * from directivos where empresa_id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, empresa.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Directivo directivo = new Directivo(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("dni"), rs.getString("correo"),empresa);

				directivos.add(directivo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeConnection();

		return directivos;
	}
	
	
	
	
	
	@Override
	public Empresa buscarPorId(int id) {
		Empresa empresa = null;
		try {
			connection = openConnection();
			String query = "Select * from empresas where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				empresa = new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("cif"),
						rs.getFloat("presupuesto"), null);
			}
			empresa.setTotalDirectivos(obetenerDirectivos(empresa));
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return empresa;
	}
	
	public void resetAutoIncrement() {
		try {
			connection = openConnection();
			String query = "alter table  empresas AUTO_INCREMENT=1;";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

}
