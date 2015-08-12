package es.neodoo.model.dao;

import java.util.List;

import es.neodoo.model.vo.TeacherVO;
import junit.framework.TestCase;

public class ReportDAOTest extends TestCase {

	public void testGetLstTeacher() {
		
		ReportDAO reportDAO = new ReportDAO();
		List<TeacherVO> teachers = reportDAO.getLstTeacher();

		assertNotNull(teachers);
		
	}
	
	public void insertTeachers() {
		// TODO Test executeUpdate INSERT
		fail("");
	}
	
	public void cleanDatabase() {
		// TODO Test execute DELETE
		fail("");
	}
	
}
