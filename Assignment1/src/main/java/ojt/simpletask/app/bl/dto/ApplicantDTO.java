package ojt.simpletask.app.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> ApplicantDTO Class</h2>
 * <p>
 * Process for Displaying ApplicantDTO
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDTO {
	/**
	 * <h2> id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	private Integer id;
	/**
	 * <h2> username</h2>
	 * <p>
	 * username
	 * </p>
	 */
	private String username;
	/**
	 * <h2> email</h2>
	 * <p>
	 * email
	 * </p>
	 */
	private String email;
	/**
	 * <h2> phone</h2>
	 * <p>
	 * phone
	 * </p>
	 */
	private String phone;
	/**
	 * <h2> address</h2>
	 * <p>
	 * address
	 * </p>
	 */
	private String address;
}
