package es.neodoo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class OperationDB {
		
	public Connection conectar() {
		
		Connection conexion = null;
		
		try {
			// Se registra el Driver de MySQL
			DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());

			// Se obtiene una conexión con la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso", "root", "");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.conexion = conexion;
		
		return conexion;
	}


	public void desconectar(Connection conexion) {
		
		try {
			// Se cierra la conexión con la base de datos.
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
