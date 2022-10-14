package prZoologicoDAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseConnection {

	Connection connection;
	
	public Connection getConnection() {
		String dbname= "bd_zoologico";
		String username = "root";
		String password = "juanmiguel";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //indica el driver que estamos utilizando
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname, username , password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
