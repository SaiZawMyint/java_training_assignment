package ojt.simpletask.app.micro.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	FileOutputStream fileout;
	FileInputStream filein;
	Map<String, Object[]> datas;
	Set<String> keyset;
	Iterator<Row> rowIterator;
	Iterator<Cell> cellIterator;
	File file;

	public void writeExcel(String filename, String tablename, Map<String, Object[]> datamap) throws IOException {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(tablename);
		int rowcount = 0, cellcount = 0;
		Row row = null;
		Cell cell = null;
		Object[] datas;
		if (datamap.size() > 0) {
			keyset = datamap.keySet();
			for (String key : keyset) {
				row = sheet.createRow(rowcount++);
				datas = datamap.get(key);
				for (Object data : datas) {
					cell = row.createCell(cellcount++);
					if (data instanceof String)
						cell.setCellValue((String) data);
					else if (data instanceof Integer)
						cell.setCellValue((Integer) data);
				}
			}
		}
		// write file
		fileout = new FileOutputStream(new File(filename));
		workbook.write(fileout);
		fileout.close();
		System.out.println("File write done");
	}

	public Map<String, Object[]> readExcel(String filename) throws IOException {
		filein = new FileInputStream(new File(filename));
		workbook = new XSSFWorkbook(filein);
		sheet = workbook.getSheetAt(0);
		rowIterator = sheet.rowIterator();
		Row row = null;
		Cell cell = null;
		int rowcount = 0;
		Map<String, Object[]> exceldata = new HashMap<String, Object[]>();
		ArrayList<Object> data;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			cellIterator = row.cellIterator();
			rowcount++;
			data = new ArrayList<Object>();
			while (cellIterator.hasNext()) {
				cell = cellIterator.next();
				data.add(cell);
			}
			exceldata.put(rowcount + "", data.toArray());
		}
		return exceldata;
	}
}
