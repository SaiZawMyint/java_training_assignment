package ojt.simpletask.app.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import ojt.simpletask.app.common.excel.Constant;

/**
 * <h2>ExcelFileValidator Class</h2>
 * <p>
 * Process for Displaying ExcelFileValidator
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public class ExcelFileValidator implements ConstraintValidator<ExcelFile, MultipartFile> {

	/**
	 * <h2>isValid</h2>
	 * <p>
	 * Check the validation of multipart file.
	 * </p>
	 * 
	 * @param value   MultipartFile
	 * @param context ConstraintValidatorContext
	 * @return
	 */
	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		if (value != null) {
			return !value.isEmpty() && value.getContentType().equals(Constant.EXCELFILETYPE);
		}
		return false;
	}

}
