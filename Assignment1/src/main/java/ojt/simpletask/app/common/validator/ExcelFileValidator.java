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
		boolean valid = false;
		if (value != null) {
			if (value.isEmpty()) {
				valid = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("File is empty!").addConstraintViolation();
			} else if (!value.getContentType().equals(Constant.EXCELFILETYPE)) {
				valid = false;
			} else if (value.getSize() >= 20971520) {
				valid = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("File exceeded the maximun size! \n Current File Size : "
						+ value.getSize() + "\n Max File Size : 20971520.").addConstraintViolation();
			} else {
				valid = true;
			}
		} else {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Please select a file to upload!").addConstraintViolation();
		}
		return valid;
	}

}
