package ojt.simpletask.app.bl.service.form;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * <h2> ExcelService Class</h2>
 * <p>
 * Process for Displaying ExcelService
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface ExcelService {
	/**
	 * <h2> doDownlaodCourse</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return ByteArrayInputStream
	 */
	public ByteArrayInputStream doDownlaodCourse();
	
	/**
	 * <h2> hasExcelFormat</h2>
	 * <p>
	 * Check excel format.
	 * </p>
	 *
	 * @param file MultipartFile
	 * @return
	 * @return boolean
	 */
	public boolean hasExcelFormat(MultipartFile file);
	/**
	 * <h2> saveExcelToCourse</h2>
	 * <p>
	 * Save excel to course.
	 * </p>
	 *
	 * @param file MultipartFile
	 * @return void
	 */
	public String doSaveExcelToCourse(MultipartFile file,String defaultsetting) throws IOException ;
}
