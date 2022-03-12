package ojt.simpletask.app.persistence.entity.admin;

import java.io.Serializable;

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
 * <h2> Authorities Class</h2>
 * <p>
 * Process for Displaying Authorities
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
@Table(name="authorities")
public class Authorities implements Serializable{

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
	 * Authority id.
	 * </p>
	 */
	@Id
	@Column(name="author_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * <h2> name</h2>
	 * <p>
	 * Author.
	 * </p>
	 */
	@Column(name="author")
	private String name;

}
