package ojt.simpletask.app.common.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * <h2> ExcelFile Class</h2>
 * <p>
 * Process for Displaying ExcelFile
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Documented
@Constraint(validatedBy = {ExcelFileValidator.class,ExcelFileSetting.class})
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelFile {
	/**
	 * <h2> message</h2>
	 * <p>
	 * Message for validation.
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	String message() default "Invalid file! The selected file is not an excel file.";
	/**
	 * <h2> groups</h2>
	 * <p>
	 * Group of called class.
	 * </p>
	 *
	 * @return
	 * @return Class<?>[]
	 */
	Class<?>[] groups() default{};
	/**
	 * <h2> payload</h2>
	 * <p>
	 * Represented the payload.
	 * </p>
	 *
	 * @return
	 * @return Class<? extends Payload>[]
	 */
	Class<? extends Payload>[] payload() default{};
}
