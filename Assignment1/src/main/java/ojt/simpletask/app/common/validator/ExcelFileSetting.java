package ojt.simpletask.app.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <h2> ExcelFileName Class</h2>
 * <p>
 * Process for Displaying ExcelFileName
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public class ExcelFileSetting implements ConstraintValidator<ExcelFile, String>{

	/**
	 * <h2> isValid </h2>
	 * <p>
	 * Check validation.
	 * </p>
	 * 
	 * @param value String
	 * @param context ConstraintValidator
	 * @return
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean valid= value!=null && value.length() > 1 & !value.equals("NONE")?
				true : false;
		if(!valid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Please choose the default setting!").addConstraintViolation();
		}
		return valid;
	}

}
