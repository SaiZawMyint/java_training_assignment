package ojt.simpletask.app.web.form.registration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.simpletask.app.bl.dto.ApplicantDTO;

/**
 * <h2>RegistrationForm Class</h2>
 * <p>
 * Process for Displaying RegistrationForm
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	private Integer id;
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
	/**
	 * <h2>courseId</h2>
	 * <p>
	 * courseId
	 * </p>
	 */
	private Integer courseId;

	/**
	 * <h2>Constructor for RegistrationForm</h2>
	 * <p>
	 * Constructor for RegistrationForm
	 * </p>
	 * 
	 * @param app ApplicantDTO
	 */
	public RegistrationForm(ApplicantDTO app) {
		this.setId(app.getId());
		this.setUsername(app.getUsername());
		this.setEmail(app.getEmail());
		this.setPhone(app.getPhone());
		this.setAddress(app.getAddress());
	}

}
