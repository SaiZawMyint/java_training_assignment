package ojt.simpletask.app.persistence.dao;

import java.util.List;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.persistence.entity.course.Course;
import ojt.simpletask.app.web.form.registration.RegistratedForm;

/**
 * <h2>CourseDAO Class</h2>
 * <p>
 * Process for Displaying CourseDAO
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface CourseDAO {

	/**
	 * <h2>dbGetAllCourse</h2>
	 * <p>
	 * Get all courses.
	 * </p>
	 *
	 * @return
	 * @return List<Course>
	 */
	public List<Course> dbGetAllCourse();

	/**
	 * <h2>doFetchRegistratedForm</h2>
	 * <p>
	 * Fetch all registrated(applicant) from.
	 * </p>
	 *
	 * @return
	 * @return List<RegistratedForm>
	 */
	public List<RegistratedForm> dbFetchRegistratedForm();

	/**
	 * <h2>dbSaveCourseForm</h2>
	 * <p>
	 * Save course form.
	 * </p>
	 *
	 * @param id  Integer
	 * @param app ApplicantDTO
	 * @return void
	 */
	public void dbSaveCourseForm(Integer id, ApplicantDTO app);

	/**
	 * <h2>dbUpdateCourseForm</h2>
	 * <p>
	 * Update course form.
	 * </p>
	 *
	 * @param id  Integer
	 * @param app ApplicantDTO
	 * @return void
	 */
	public void dbUpdateCourseForm(Integer id, ApplicantDTO app);

	/**
	 * <h2>dbGetCourseById</h2>
	 * <p>
	 * Get course by id.
	 * </p>
	 *
	 * @param id Integer
	 * @return
	 * @return Course
	 */
	public Course dbGetCourseById(Integer id);

	/**
	 * <h2>dbDeleteCourseForm</h2>
	 * <p>
	 * Delete course form.
	 * </p>
	 *
	 * @param id     Integer
	 * @param formId Integer
	 * @return void
	 */
	public void dbDeleteCourseForm(Integer id, Integer formId);
}
