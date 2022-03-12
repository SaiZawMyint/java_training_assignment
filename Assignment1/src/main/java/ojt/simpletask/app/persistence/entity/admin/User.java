package ojt.simpletask.app.persistence.entity.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> AdminInfo Class</h2>
 * <p>
 * Process for Displaying AdminInfo
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
@Table(name="admininfo")
public class User implements Serializable {
	/**
	 * <h2> serialVersionUID</h2>
	 * <p>
	 * serialVersionUID
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <h2> id</h2>
	 * <p>
	 * User id
	 * </p>
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	/**
	 * <h2> username</h2>
	 * <p>
	 * username
	 * </p>
	 */
	@Column(name="username")
	private String username;
	/**
	 * <h2> password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	@Column(name="password")
	private String password;
	
	/**
	 * <h2> authorities</h2>
	 * <p>
	 * authorities
	 * </p>
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Authorities> authorities = new ArrayList<Authorities>();

}