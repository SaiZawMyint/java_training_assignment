package ojt.simpletask.app.common.customform;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> CustomForm Class</h2>
 * <p>
 * Process for Displaying CustomForm
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomForm {
	/**
	 * <h2> name</h2>
	 * <p>
	 * name
	 * </p>
	 */
	private String name;
	/**
	 * <h2> form</h2>
	 * <p>
	 * form
	 * </p>
	 */
	private Object form;
	/**
	 * <h2> isNull</h2>
	 * <p>
	 * Check null.
	 * </p>
	 *
	 * @return
	 * @return boolean
	 */
	public boolean isNull() {
		return this.name == null && this.form == null ? true:false;
	}
}
