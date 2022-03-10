package ojt.simpletask.app.bl.service.form.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.simpletask.app.bl.service.form.ExcelService;
import ojt.simpletask.app.persistence.dao.CourseDAO;
import ojt.simpletask.app.persistence.dao.ExcelDAO;

/**
 * <h2> ExcelServiceImpl Class</h2>
 * <p>
 * Process for Displaying ExcelServiceImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Transactional
@Service
public class ExcelServiceImpl implements ExcelService{

	/**
	 * <h2> excelDAO</h2>
	 * <p>
	 * excelDAO
	 * </p>
	 */
	@Autowired 
	ExcelDAO excelDAO;
	
	/**
	 * <h2> courseDAO</h2>
	 * <p>
	 * courseDAO
	 * </p>
	 */
	@Autowired
	CourseDAO courseDAO;
	
	/**
	 * <h2> doDownlaodCourse </h2>
	 * <p>
	 * Download corse
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public ByteArrayInputStream doDownlaodCourse() {
		ByteArrayInputStream in = null;
		try {
			in = excelDAO.dbDownloadCourse(courseDAO.dbGetAllCourse());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return in;
	}

}
