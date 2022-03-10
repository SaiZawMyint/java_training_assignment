package ojt.simpletask.app.persistence.entity.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>Applicant Class</h2>
 * <p>
 * Process for Displaying Applicant
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applicant")
public class Applicant {
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	@Id
	@Column(name = "user_id", insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * <h2>username</h2>
	 * <p>
	 * username
	 * </p>
	 */
	@Column(name = "username")
	private String username;
	/**
	 * <h2>email</h2>
	 * <p>
	 * email
	 * </p>
	 */
	@Column(name = "email")
	private String email;
	/**
	 * <h2>phonenumber</h2>
	 * <p>
	 * phonenumber
	 * </p>
	 */
	@Column(name = "phonenumber")
	private String phonenumber;
	/**
	 * <h2>address</h2>
	 * <p>
	 * address
	 * </p>
	 */
	@Column(name = "address")
	private String address;

}
