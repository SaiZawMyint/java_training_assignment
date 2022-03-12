package ojt.simpletask.app.web.form.registration;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>LoginForm Class</h2>
 * <p>
 * Process for Displaying LoginForm
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
	/**
	 * <h2>username</h2>
	 * <p>
	 * username
	 * </p>
	 */
	@NotBlank
	private String username;
	/**
	 * <h2>password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	@NotBlank
	private String password;
}
