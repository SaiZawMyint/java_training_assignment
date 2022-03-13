package ojt.simpletask.app.common.excel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

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
	 * <h2> errors</h2>
	 * <p>
	 * Common validate's errors.
	 * </p>
	 */
	public static ArrayList<String> errors = new ArrayList<String>();
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

	/**
	 * <h2> isValid</h2>
	 * <p>
	 * Check excel is a valid form or not.
	 * </p>
	 *
	 * @param sheet Sheet
	 * @return
	 * @throws Exception
	 * @return boolean
	 */
	public static boolean isValid(XSSFSheet sheet) throws Exception {
		boolean valid = true;
		Row r = null;
		Cell c = null;
		ArrayList<Boolean> check = new ArrayList<Boolean>();
		Iterator<Row> rows = sheet.rowIterator();
		ArrayList<String> sheetHdr = Excel.getSheetHeaders(rows.next());
		if (!sheetHdr.get(0).equalsIgnoreCase("coursename")) {
			valid = false;
			Excel.errors.add("The first row and first column of excel must represent Course Name.");
		}
		int rown = 1;
		while (rows.hasNext()) {
			r = rows.next();
			int lastcol = Math.max(r.getLastCellNum(), APPLICANT_DATA.length);
			for (int cn = 0; cn < lastcol; cn++) {
				c = r.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (c == null) {
					valid = false;
					Excel.errors.add("Null excel data has been found on row : <u>"+(rown+1)+"</u>, column : <u>"+(cn+1)+"</u>");
				}
				check.add(validateAll(c,sheetHdr.get(cn),rown+1,cn+1));
			}
			rown++;
		}
		for(boolean b:check) {
			if(!b){
				valid = false;
				break;
			}
		}
		if(!valid) {
			String errmessage = "";
			for(String error:Excel.errors) {
				errmessage += error+"<br>";
			}
			Excel.errors.clear();
			throw new Exception(errmessage);
		}
		return valid;
	}
	
	/**
	 * <h2> validateAll</h2>
	 * <p>
	 * Validate all
	 * </p>
	 *
	 * @param c Cell
	 * @return
	 * @return boolean
	 * @throws Exception 
	 */
	public static boolean validateAll(Cell c,String compare,int row, int col){
		boolean valid = true;
		
		if(compare.equalsIgnoreCase("coursename")) {
			valid = (validateName(c,compare,row,col));
		}else if(compare.equalsIgnoreCase("username")) {
			valid = (validateName(c,compare,row,col));
		}else if(compare.equalsIgnoreCase("email")) {
			valid = (Excel.validateEmail(c,compare,row,col));
		}else if(compare.equalsIgnoreCase("phone")) {
			valid = (Excel.validatePhonenumber(c,compare,row,col));
		}else if(compare.equalsIgnoreCase("address")) {
			valid = (Excel.validateName(c,compare,row,col));
		}
		return valid;
	}
	/**
	 * <h2> validateName</h2>
	 * <p>
	 * Valid names.
	 * </p>
	 *
	 * @param c Cell
	 * @return
	 * @return boolean
	 * @throws Exception 
	 */
	public static boolean validateName(Cell c,String compare,int row,int col) {
		boolean valid = false;
		if(Excel.parseStringResult(c).length() > 3) {
			valid = true;
		}else {
			valid = false;
			Excel.errors.add("Invalid "+compare+" '"+Excel.parseStringResult(c)+"'. The given value is too short.<br>Cause on : row : <u>"+row+"</u>, column : <u>"+col+"</u><br>");
		}
		return valid;
	}
	/**
	 * <h2> validateEmail</h2>
	 * <p>
	 * Valid email
	 * </p>
	 *
	 * @param c Cell
	 * @return
	 * @return boolean
	 * @throws Exception 
	 */
	public static boolean validateEmail(Cell c,String compare,int row,int col){
		boolean valid = false;
		if(new EmailValidator().isValid(Excel.parseStringResult(c), null)) {
			valid = true;
		}else {
			Excel.errors.add("Invalid "+compare+" '"+Excel.parseStringResult(c)+"'. The given email address is invalid email format.<br>Cause on : row : <u>"+row+"</u>, column : <u>"+col+"</u><br>");
		}
		return valid;
	}
	/**
	 * <h2> validatePhonenumber</h2>
	 * <p>
	 * Valide phone number.
	 * </p>
	 *
	 * @param c Cell
	 * @return
	 * @return boolean
	 * @throws Exception 
	 */
	public static boolean validatePhonenumber(Cell c,String compare,int row,int col){
		boolean valid = false;
		if(Excel.parseStringResult(c).length() > 10 && Excel.parseStringResult(c).length() < 12)
			valid = true;
		else
			Excel.errors.add("Invalid "+compare+" '"+Excel.parseStringResult(c)+"'. The given phone number is invalid.<br>Cause on : row : <u>"+row+"</u>, column : <u>"+col+"</u><br>");
		return valid;
	}
}
