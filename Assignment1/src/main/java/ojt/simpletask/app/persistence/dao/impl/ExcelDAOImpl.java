package ojt.simpletask.app.persistence.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import ojt.simpletask.app.persistence.dao.ExcelDAO;
import ojt.simpletask.app.persistence.entity.course.Course;

/**
 * <h2>ExcelDAOImpl Class</h2>
 * <p>
 * Process for Displaying ExcelDAOImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Repository
public class ExcelDAOImpl implements ExcelDAO {

	/**
	 * <h2>workbook</h2>
	 * <p>
	 * workbook
	 * </p>
	 */
	XSSFWorkbook workbook;
	/**
	 * <h2>sheet</h2>
	 * <p>
	 * sheet
	 * </p>
	 */
	XSSFSheet sheet;
	/**
	 * <h2>title</h2>
	 * <p>
	 * title
	 * </p>
	 */
	String title;

	/**
	 * <h2>dbDownloadCourse</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param courses List<Course>
	 * @return
	 * @throws IOException
	 */
	@Override
	public ByteArrayInputStream dbDownloadCourse(List<Course> courses) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		title = "Course";
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(title);
		Row hdrRow = sheet.createRow(0);
		Object[] courseheader = new Object[] { "ID", "Course Name", "Schedule", "Prices", "Post Date" };
		Cell cell;
		int count = 0;
		for (Object obj : courseheader) {
			cell = hdrRow.createCell(count);
			if (obj instanceof String)
				cell.setCellValue((String) obj);
			else if (obj instanceof Integer)
				cell.setCellValue((Integer) obj);
			count++;
		}
		Row row = null;
		int rowcount = 1;
		for (Course c : courses) {
			row = sheet.createRow(rowcount++);
			row.createCell(0).setCellValue(c.getId());
			row.createCell(1).setCellValue(c.getCoursename());
			row.createCell(2).setCellValue(c.getSchedule());
			row.createCell(3).setCellValue(c.getPrices());
			row.createCell(4).setCellValue(c.getPostdate());
		}
		workbook.write(bout);
		return new ByteArrayInputStream(bout.toByteArray());
	}

}
