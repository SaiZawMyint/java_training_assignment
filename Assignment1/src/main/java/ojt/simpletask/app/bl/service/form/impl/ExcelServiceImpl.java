package ojt.simpletask.app.bl.service.form.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ojt.simpletask.app.bl.service.form.ExcelService;
import ojt.simpletask.app.common.excel.Constant;
import ojt.simpletask.app.common.excel.Excel;
import ojt.simpletask.app.persistence.dao.CourseDAO;
import ojt.simpletask.app.persistence.entity.course.Applicant;
import ojt.simpletask.app.persistence.entity.course.Course;

/**
 * <h2>ExcelServiceImpl Class</h2>
 * <p>
 * Process for Displaying ExcelServiceImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Transactional
@Service
public class ExcelServiceImpl implements ExcelService {

	/**
	 * <h2>courseDAO</h2>
	 * <p>
	 * courseDAO
	 * </p>
	 */
	@Autowired
	CourseDAO courseDAO;

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

	Row rowheader;

	/**
	 * <h2>doDownlaodCourse</h2>
	 * <p>
	 * Download corse
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public ByteArrayInputStream doDownlaodCourse() {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		title = "Course";
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(title);
		Row hdrRow = sheet.createRow(0);
		Object[] courseheader = new Object[] { "Course Name", "Username", "Email", "Phone Number", "Address" };
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
		List<Course> courses = courseDAO.dbGetAllCourse();
		for (Course c : courses) {
			for (Applicant a : c.getApplicants()) {
				row = sheet.createRow(rowcount++);
				row.createCell(0).setCellValue(c.getCoursename());
				row.createCell(1).setCellValue(a.getUsername());
				row.createCell(2).setCellValue(a.getEmail());
				row.createCell(3).setCellValue(a.getPhonenumber());
				row.createCell(4).setCellValue(a.getAddress());
			}
		}
		try {
			workbook.write(bout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ByteArrayInputStream(bout.toByteArray());
	}

	/**
	 * <h2>hasExcelFormat</h2>
	 * <p>
	 * Check for excel format.
	 * </p>
	 * 
	 * @param file MultipartFile
	 * @return
	 */
	@Override
	public boolean hasExcelFormat(MultipartFile file) {
		if (!Constant.EXCELFILETYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	/**
	 * <h2>doSaveExcelToCourse</h2>
	 * <p>
	 * Save course data from excel file.
	 * </p>
	 * 
	 * @param file      MultipartFile
	 * @param sheetname String
	 * @return
	 * @throws IOException
	 */
	@Override
	public String doSaveExcelToCourse(MultipartFile file, String defaultsetting) throws IOException {
		String result = "";
		workbook = new XSSFWorkbook(file.getInputStream());
		// I'm getting the first sheet only for this assignment.
		sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		rowheader = rows.next();
		ArrayList<String> sheetHdr = Excel.getSheetHeaders(rowheader);
		// check valid excel data
		if (Excel.validateExcelData(sheetHdr) && Excel.isValid(sheet)) {
			Iterator<Cell> cells = null;
			int cellcount = 0;
			Row cur = null;
			Cell cell = null;
			ArrayList<Course> dbcourses = new ArrayList<Course>();
			Course c = null;
			Applicant app = null;
			while (rows.hasNext()) {
				cur = rows.next();
				cells = cur.cellIterator();
				c = courseDAO.dbGetCourseByName(Excel.parseStringResult(cur.getCell(0)));
				if (c == null) {
					if (defaultsetting.equals(Constant.AUTO_GENERATE_COURSE)) {
						c = new Course(null, Excel.parseStringResult(cur.getCell(0)), "Not Set", "0", null,
								new ArrayList<Applicant>());
						courseDAO.dbSaveCourse(c);
					} else if (defaultsetting.equals(Constant.SKIP_UNKNOWN_COURSE))
						continue;
				}

				System.out.println(c.getId() + "---" + c.getCoursename());
				cells = cur.cellIterator();
				cellcount = 0;
				app = new Applicant();
				while (cells.hasNext()) {
					cell = cells.next();
					String curhdr = sheetHdr.get(cellcount);
					if (curhdr.equalsIgnoreCase("username")) {
						app.setUsername(Excel.parseStringResult(cell));
					} else if (curhdr.equalsIgnoreCase("email")) {
						app.setEmail(Excel.parseStringResult(cell));
					} else if (curhdr.equalsIgnoreCase("phonenumber")) {
						app.setPhonenumber(Excel.parseStringResult(cell));
					} else if (curhdr.equalsIgnoreCase("address")) {
						app.setAddress(Excel.parseStringResult(cell));
					}
					cellcount++;
				}
				c.getApplicants().add(app);
				dbcourses.add(c);
			}
			workbook.close();
			courseDAO.dbSaveOrUpdateMultipalCourses(dbcourses);
			result = "M_SUCCESS_EXCEL_UPLOAD";

		} else {
			result = "M_ER_FILL_FULL_EXCEL";
		}
		return result;
	}
}
