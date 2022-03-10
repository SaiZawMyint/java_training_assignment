package ojt.simpletask.app.persistence.entity.course;

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
 * <h2>Course Class</h2>
 * <p>
 * Process for Displaying Course
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
@Table(name = "course")
public class Course {
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	@Id
	@Column(name = "course_id", insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * <h2>coursename</h2>
	 * <p>
	 * coursename
	 * </p>
	 */
	@Column(name = "course_name")
	private String coursename;
	/**
	 * <h2>schedule</h2>
	 * <p>
	 * schedule
	 * </p>
	 */
	@Column(name = "schedule")
	private String schedule;
	/**
	 * <h2>prices</h2>
	 * <p>
	 * prices
	 * </p>
	 */
	@Column(name = "prices")
	private String prices;
	/**
	 * <h2>postdate</h2>
	 * <p>
	 * postdate
	 * </p>
	 */
	@Column(name = "date")
	private String postdate;

	/**
	 * <h2>applicants</h2>
	 * <p>
	 * applicants
	 * </p>
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "online_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<Applicant> applicants = new ArrayList<Applicant>();
}
