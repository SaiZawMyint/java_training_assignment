package ojt.simpletask.app.web.form.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>CourseForm Class</h2>
 * <p>
 * Process for Displaying CourseForm
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseForm {
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	private Integer id;
	/**
	 * <h2>coursename</h2>
	 * <p>
	 * coursename
	 * </p>
	 */
	private String coursename;
	/**
	 * <h2>schedule</h2>
	 * <p>
	 * schedule
	 * </p>
	 */
	private String schedule;
	/**
	 * <h2>price</h2>
	 * <p>
	 * price
	 * </p>
	 */
	private String price;
	/**
	 * <h2>date</h2>
	 * <p>
	 * date
	 * </p>
	 */
	private String date;
}
