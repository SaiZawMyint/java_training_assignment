package ojt.simpletask.app.bl.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.simpletask.app.persistence.entity.course.Applicant;

/**
 * <h2>CourseDTO Class</h2>
 * <p>
 * Process for Displaying CourseDTO
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
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
	private LocalDate date;

	/**
	 * <h2>applicants</h2>
	 * <p>
	 * applicants
	 * </p>
	 */
	private List<Applicant> applicants;
}
