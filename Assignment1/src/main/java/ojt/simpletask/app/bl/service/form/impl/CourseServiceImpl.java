package ojt.simpletask.app.bl.service.form.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.bl.dto.CourseDTO;
import ojt.simpletask.app.bl.service.form.CourseService;
import ojt.simpletask.app.persistence.dao.CourseDAO;
import ojt.simpletask.app.persistence.entity.course.Course;
import ojt.simpletask.app.web.form.registration.RegistratedForm;

/**
 * <h2> CourseServiceImpl Class</h2>
 * <p>
 * Process for Displaying CourseServiceImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Transactional
@Service
public class CourseServiceImpl implements CourseService {

	/**
	 * <h2> courseDAO</h2>
	 * <p>
	 * courseDAO
	 * </p>
	 */
	@Autowired
	private CourseDAO courseDAO;

	/**
	 * <h2> doGetAllCourse </h2>
	 * <p>
	 * Get all courses.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<CourseDTO> doGetAllCourse() {
		List<CourseDTO> list = new ArrayList<CourseDTO>();
		for (Course exp : courseDAO.dbGetAllCourse()) {
			CourseDTO dto = new CourseDTO(exp.getId(), exp.getCoursename(), exp.getSchedule(), exp.getPrices(),
					exp.getPostdate(), exp.getApplicants());
			list.add(dto);
		}
		return list;
	}

	/**
	 * <h2> doDeleteCourse </h2>
	 * <p>
	 * Delete course.
	 * </p>
	 * 
	 * @param id Integer
	 */
	@Override
	public void doDeleteCourse(Integer id) {
		//this is for security part(assignment 3).
	}

	/**
	 * <h2> doFetchRegistratedForm </h2>
	 * <p>
	 * Fetach all registrated(applicant) from.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<RegistratedForm> doFetchRegistratedForm() {
		return courseDAO.dbFetchRegistratedForm();
	}

	/**
	 * <h2> doSaveCourseForm </h2>
	 * <p>
	 * Save registration(applicant) form to course.
	 * </p>
	 * 
	 * @param id Integer
	 * @param app ApplicantDTO
	 */
	@Override
	public void doSaveCourseForm(Integer id, ApplicantDTO app) {
		courseDAO.dbSaveCourseForm(id, app);
	}

	/**
	 * <h2> doUpdateCourseForm </h2>
	 * <p>
	 * Update registration(applicant) form to course.
	 * </p>
	 * 
	 * @param id Integer
	 * @param app ApplicantDTO
	 */
	@Override
	public void doUpdateCourseForm(Integer id, ApplicantDTO app) {
		courseDAO.dbUpdateCourseForm(id, app);
	}

	/**
	 * <h2> doDeleteCourseForm </h2>
	 * <p>
	 * Delete registration(applicant) form to course.
	 * </p>
	 * 
	 * @param id Integer
	 * @param formId Integer
	 */
	@Override
	public void doDeleteCourseForm(Integer id, Integer formId) {
		courseDAO.dbDeleteCourseForm(id, formId);
	}

}
