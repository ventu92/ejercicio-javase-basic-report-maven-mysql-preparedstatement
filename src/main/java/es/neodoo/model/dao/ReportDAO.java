package es.neodoo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import es.neodoo.model.vo.TeacherVO;
import es.neodoo.model.vo.UserTeacherVO;
import es.neodoo.service.OperationDB;

public class ReportDAO extends OperationDB {
	private Connection conexion = null;
	private OperationDB operationDB = null;

	public List<TeacherVO> getLstTeacher() {

		List<TeacherVO> teachers = new ArrayList();
		try {

			// Se realiza la consulta. Los resultados se guardan en el
			Statement s = (Statement) conexion.createStatement();

			ResultSet rs = s.executeQuery("select * from user");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {

				TeacherVO teacher = null;

				teacher = new TeacherVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				teachers.add(teacher);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;

	}

	public void insertTeachers() {

		// Se realiza la consulta. Los resultados se guardan en el
		java.sql.PreparedStatement ps1 = null;
		java.sql.PreparedStatement ps2 = null;
		String nombres[]={"Alex","Federico","Manuel","Antonio","Jesus"};
		String apellidos[]={"Ventura","Martinez","Gimenez","Pascual","Gomez"};
		String dni[]={"12345678J","87654321W","13579264K","12349854T","09876543M"};
		String centros[]={"Sierra de Guara","Los Enlaces","Salesianos","Mor de Fuentes","Corona de Aragon"};
		String asignaturas[]={"Matematicas","Fisica","Quimica","Lenguaje","Ingles"};
		
		String insert1 = ("INSERT INTO user (nombre ,apellidos , dni)" + "VALUES(?,?,?);");
		String insert2 = ("INSERT INTO user_teacher (centro,asignatura)" + "VALUES(?,?);");

		try {
			conexion.setAutoCommit(false);
			ps1 = conexion.prepareStatement(insert1);
			ps2 = conexion.prepareStatement(insert2);
			
			for(int i=0 ; i<nombres.length ; i++ ){
				ps1.setString(1,nombres[i]);
				ps1.setString(2,apellidos[i]);
				ps1.setString(3,dni[i]);
				ps1.executeUpdate();
			}
			
			for(int i=0 ; i<centros.length ; i++ ){
				ps2.setString(1,centros[i]);
				ps2.setString(2,asignaturas[i]);
				ps2.executeUpdate();
			}
			
			conexion.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteData() {

		try {
			// Se realiza la consulta. Los resultados se guardan en el
			Statement s1 = (Statement) conexion.createStatement();

			boolean delete = s1.execute("DELETE FROM user WHERE nombre = 'fernando';");

			if (delete == false) {
				System.out.println("Se ha realizado correctamente el borrado de los datos en la tabla USER");
			} else {
				System.out.println("NO se ha realizado correctamente el borrado de los datos en la tabla USER");
			}

			// Se cierra la conexión con la base de datos.

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initConection() {

		OperationDB operationDB = new OperationDB();
		this.conexion = operationDB.conectar();
	}

	public void closeConection() {
		operationDB.desconectar(conexion);
	}
}
