package ojt.simpletask.app.web.form.registration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>ApplicantForm Class</h2>
 * <p>
 * Process for Displaying ApplicantForm
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantForm {
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	private Integer id;
	/**
	 * <h2>course_id</h2>
	 * <p>
	 * course_id
	 * </p>
	 */
	private Integer course_id;
	/**
	 * <h2>username</h2>
	 * <p>
	 * username
	 * </p>
	 */
	@NotBlank
	private String username;
	/**
	 * <h2>email</h2>
	 * <p>
	 * email
	 * </p>
	 */
	@NotBlank
	private String email;
	/**
	 * <h2>phone</h2>
	 * <p>
	 * phone
	 * </p>
	 */
	@Size(min = 10)
	private String phone;
	/**
	 * <h2>address</h2>
	 * <p>
	 * address
	 * </p>
	 */
	@NotBlank
	private String address;

}
