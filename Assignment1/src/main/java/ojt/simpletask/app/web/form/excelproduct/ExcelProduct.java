package ojt.simpletask.app.web.form.excelproduct;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.simpletask.app.common.validator.ExcelFile;

/**
 * <h2>ExcelProduct Class</h2>
 * <p>
 * Process for Displaying ExcelProduct
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcelProduct {
	/**
	 * <h2>coursename</h2>
	 * <p>
	 * coursename
	 * </p>
	 */
	@ExcelFile
	private String coursename;

	/**
	 * <h2>excfile</h2>
	 * <p>
	 * excfile
	 * </p>
	 */
	@ExcelFile
	private MultipartFile excfile;
}
