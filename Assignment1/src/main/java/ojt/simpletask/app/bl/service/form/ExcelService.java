package ojt.simpletask.app.bl.service.form;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ojt.simpletask.app.web.form.registration.RegistratedForm;

/**
 * <h2>ExcelService Class</h2>
 * <p>
 * Process for Displaying ExcelService
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface ExcelService {
	/**
	 * <h2>doDownlaodCourse</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return ByteArrayInputStream
	 */
	public ByteArrayInputStream doDownlaodCourse();

	/**
	 * <h2>hasExcelFormat</h2>
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
	 * <h2>saveExcelToCourse</h2>
	 * <p>
	 * Save excel to course.
	 * </p>
	 *
	 * @param file MultipartFile
	 * @return void
	 */
	public List<RegistratedForm> doGetExcelData(MultipartFile file, String defaultsetting,Exception exp) throws IOException,Exception;
}
