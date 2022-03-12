package ojt.simpletask.app.common.excel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * <h2>Excel Class</h2>
 * <p>
 * Process for Displaying Excel
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public class Excel {
	/**
	 * <h2>APPLICANT_DATA</h2>
	 * <p>
	 * APPLICANT_DATA
	 * </p>
	 */
	private static final String[] APPLICANT_DATA = { "coursename", "username", "email", "phonenumber", "address" };

	/**
	 * <h2>parseStringResult</h2>
	 * <p>
	 * Parse all string value from cell.
	 * </p>
	 *
	 * @param cell Cell
	 * @return
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String parseStringResult(Cell cell) {
		String res = "";
		cell.setCellType(CellType.STRING);
		res = cell.getStringCellValue();
		return res;
	}

	/**
	 * <h2>getSheetHeaders</h2>
	 * <p>
	 * Get sheet header to know what column is representing for.
	 * </p>
	 *
	 * @param rowhdr Row
	 * @return
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> getSheetHeaders(Row rowhdr) {
		ArrayList<String> cells = new ArrayList<String>();
		Iterator<Cell> cellItr = rowhdr.cellIterator();
		Cell cell = null;
		while (cellItr.hasNext()) {
			cell = cellItr.next();
			cells.add(Excel.parseStringResult(cell).toLowerCase().replaceAll("\\s", ""));
		}
		return cells;
	}

	/**
	 * <h2>parseCourseId</h2>
	 * <p>
	 * Parse course id from excel file name format in project.
	 * </p>
	 *
	 * @param coursestring String
	 * @return
	 * @return Integer
	 */
	public static Integer parseCourseId(String coursestring) {
		Integer integer = null;
		if (coursestring.contains("-")) {
			String s = coursestring.substring(0, coursestring.indexOf('-'));
			s = s.trim();
			integer = Integer.parseInt(s);
		} else {
			throw new Error(coursestring + " is not a valid string to cast course id.");
		}
		return integer;
	}

	/**
	 * <h2>validateExcelData</h2>
	 * <p>
	 * Validata excel data.
	 * </p>
	 *
	 * @param sheetHdrs List
	 * @return
	 * @return boolean
	 */
	public static boolean validateExcelData(List<String> sheetHdrs) {
		boolean valid = true;
		boolean[] check = new boolean[APPLICANT_DATA.length];
		int countcheck = 0;
		// record sheet exist applicant data.
		if (APPLICANT_DATA.length == sheetHdrs.size()) {
			for (String s : sheetHdrs) {
				for (String checkstr : APPLICANT_DATA) {
					if (s.equals(checkstr)) {
						check[countcheck] = true;
						countcheck++;
						break;
					}
				}
			}
			// init check
			for (boolean b : check) {
				if (!b) {
					valid = false;
					break;
				}
			}
		} else {
			valid = false;
		}

		return valid;
	}

	public static boolean isValid(XSSFSheet sheet) {
		boolean valid = true;
		Row r = null;
		Cell c = null;
		Iterator<Row> rows = sheet.rowIterator();
		int rown = 0;
		while (rows.hasNext()) {
			r = rows.next();
			int lastcol = Math.max(r.getLastCellNum(), APPLICANT_DATA.length);
			for (int cn = 0; cn < lastcol; cn++) {
				c = r.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (c == null) {
					valid = false;
				} else if (rown == 0 && !Excel.parseStringResult(c).toLowerCase().replaceAll("\\s", "")
						.equalsIgnoreCase("coursename")) {
					valid = false;
				} else {
					valid = true;
				}
			}
			rown++;
		}
		System.out.println(valid);
		return valid;
	}

}
