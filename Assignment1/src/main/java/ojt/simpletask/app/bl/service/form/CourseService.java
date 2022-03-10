package ojt.simpletask.app.bl.service.form;

import java.util.List;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.bl.dto.CourseDTO;
import ojt.simpletask.app.web.form.registration.RegistratedForm;

/**
 * <h2>CourseService Class</h2>
 * <p>
 * Process for Displaying CourseService
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface CourseService {

	/**
	 * <h2>doGetAllCourse</h2>
	 * <p>
	 * Get all avaliable course
	 * </p>
	 *
	 * @return
	 * @return List<CourseDTO>
	 */
	public List<CourseDTO> doGetAllCourse();

	/**
	 * <h2>doFetchRegistratedForm</h2>
	 * <p>
	 * Fetch all registrated form.
	 * </p>
	 *
	 * @return
	 * @return List<RegistratedForm>
	 */
	public List<RegistratedForm> doFetchRegistratedForm();

	/**
	 * <h2>doSaveCourseForm</h2>
	 * <p>
	 * Save registration(applicant) form to course.
	 * </p>
	 *
	 * @param id  Integer
	 * @param app ApplicantDTO
	 * @return void
	 */
	public void doSaveCourseForm(Integer id, ApplicantDTO app);

	/**
	 * <h2>doUpdateCourseForm</h2>
	 * <p>
	 * Update registration(applicant) form to course.
	 * </p>
	 *
	 * @param id  Integer
	 * @param app ApplicantDTO
	 * @return void
	 */
	public void doUpdateCourseForm(Integer id, ApplicantDTO app);

	/**
	 * <h2>doDeleteCourseForm</h2>
	 * <p>
	 * Delete registration(applicant) form to course.
	 * </p>
	 *
	 * @param id     Integer
	 * @param formId Integer
	 * @return void
	 */
	public void doDeleteCourseForm(Integer id, Integer formId);

	/**
	 * <h2>doDeleteCourse</h2>
	 * <p>
	 * Delete Course and it's related froms.
	 * </p>
	 *
	 * @param id
	 * @return void
	 */
	public void doDeleteCourse(Integer id);
}
