package ojt.simpletask.app.persistence.dao;

import java.util.List;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.bl.dto.CourseDTO;
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
	 * <h2>dbSaveCourse</h2>
	 * <p>
	 * Save course.
	 * </p>
	 *
	 * @param c Course
	 * @return void
	 */
	public void dbSaveCourse(Course c);
	/**
	 * <h2> dbUpdateCourse</h2>
	 * <p>
	 * update course.
	 * </p>
	 *
	 * @param c CourseDTO
	 * @return void
	 */
	public void dbUpdateCourse(CourseDTO c);
	/**
	 * <h2> dbDeleteCourse</h2>
	 * <p>
	 * Delete course.
	 * </p>
	 *
	 * @param id Integer
	 * @return void
	 */
	public void dbDeleteCourse(Integer id);
	/**
	 * <h2>dbSaveAllCourse</h2>
	 * <p>
	 * Save all course.
	 * </p>
	 *
	 * @param courses List
	 * @return void
	 */
	public void dbSaveAllCourse(List<Course> courses);

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
	 * <h2>dbSaveMultipalCourses</h2>
	 * <p>
	 * Save multiple courses.
	 * </p>
	 *
	 * @param courses List
	 * @return void
	 */
	public void dbSaveOrUpdateMultipalCourses(List<Course> courses);

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
	 * <h2>dbGetCourseByName</h2>
	 * <p>
	 * Get Course by name.
	 * </p>
	 *
	 * @param name Stirng
	 * @return
	 * @return Course
	 */
	public Course dbGetCourseByName(String name);

	/**
	 * <h2>dbGetCourseByAppId</h2>
	 * <p>
	 * Get course by app id.
	 * </p>
	 *
	 * @param appid Integer
	 * @return
	 * @return Course
	 */
	public Course dbGetCourseByAppId(Integer appid);

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
