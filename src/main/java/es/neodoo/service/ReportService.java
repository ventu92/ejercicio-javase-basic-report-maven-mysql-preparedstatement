package es.neodoo.service;

import java.util.List;

import es.neodoo.model.dao.ReportDAO;
import es.neodoo.model.vo.TeacherVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportService {

	public void generate() {

		// Obtenemos el listado de profesores
		ReportDAO reportDAO = new ReportDAO();
		reportDAO.initConection();
		//doReport(teachers);
		reportDAO.insertTeachers();
		reportDAO.deleteData();
		reportDAO.closeConection();
	
		// Generamos el informe con el listado obtenido
		List<TeacherVO> teachers = reportDAO.getLstTeacher();

	}

	public void doReport(List<TeacherVO> teachers) {

		JasperReport reporte;
		
		try {

			reporte = (JasperReport) JRLoader.loadObjectFromFile("files/Teachers.jasper");

			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
					null, new JRBeanCollectionDataSource(teachers));

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("files/Teachers.pdf"));
			exporter.exportReport();

		} catch (JRException e) {
			e.printStackTrace();
		}

	}

}
