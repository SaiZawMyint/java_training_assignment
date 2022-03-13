package ojt.simpletask.app.bl.service.form.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.bl.dto.CourseDTO;
import ojt.simpletask.app.bl.service.form.CourseService;
import ojt.simpletask.app.persistence.dao.ApplicantDAO;
import ojt.simpletask.app.persistence.dao.CourseDAO;
import ojt.simpletask.app.persistence.entity.course.Applicant;
import ojt.simpletask.app.persistence.entity.course.Course;
import ojt.simpletask.app.web.form.registration.RegistratedForm;

/**
 * <h2>CourseServiceImpl Class</h2>
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
	 * <h2>courseDAO</h2>
	 * <p>
	 * courseDAO
	 * </p>
	 */
	@Autowired
	private CourseDAO courseDAO;
	/**
	 * <h2>applicantDAO</h2>
	 * <p>
	 * applicantDAO
	 * </p>
	 */
	@Autowired
	private ApplicantDAO applicantDAO;

	/**
	 * <h2>doGetAllCourse</h2>
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
			CourseDTO dto = null;
			dto = new CourseDTO(exp.getId(), exp.getCoursename(), exp.getSchedule(), exp.getPrices(), exp.getPostdate(),
					exp.getApplicants());
			list.add(dto);
		}
		return list;
	}

	/**
	 * <h2>doDeleteCourse</h2>
	 * <p>
	 * Delete course.
	 * </p>
	 * 
	 * @param id Integer
	 */
	@Override
	public void doDeleteCourse(Integer id) {
		courseDAO.dbDeleteCourse(id);
	}

	/**
	 * <h2>doFetchRegistratedForm</h2>
	 * <p>
	 * Fetach all registrated(applicant) from.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<RegistratedForm> doFetchRegistratedForm() {
		List<RegistratedForm> orderform = new ArrayList<RegistratedForm>();
		List<Applicant> app = applicantDAO.getAllApplicants();
		Course course = null;
		RegistratedForm forms = null;
		for (Applicant a : app) {
			System.out.println(a.getId());
			// prevent dbGetCourseByAppId which can return null or index out of bound.
			// Why these return because I'm not delete parmanently the applicant form.
			// I want to markup the data with delete_at by date in database.
			try {
				course = courseDAO.dbGetCourseByAppId(a.getId());
			} catch (IndexOutOfBoundsException e) {
				continue;
			} catch (NullPointerException e) {
				continue;
			}
			forms = new RegistratedForm();
			forms.setCourseId(course.getId());
			forms.setUserid(a.getId());
			forms.setUsername(a.getUsername());
			forms.setCoursename(course.getCoursename());
			forms.setEmail(a.getEmail());
			forms.setPhone(a.getPhonenumber());
			forms.setAddress(a.getAddress());
			orderform.add(forms);
		}
		return orderform;
	}

	/**
	 * <h2>doSaveCourseForm</h2>
	 * <p>
	 * Save registration(applicant) form to course.
	 * </p>
	 * 
	 * @param id  Integer
	 * @param app ApplicantDTO
	 */
	@Override
	public void doSaveCourseForm(Integer id, ApplicantDTO app) {
		courseDAO.dbSaveCourseForm(id, app);
	}

	/**
	 * <h2>doUpdateCourseForm</h2>
	 * <p>
	 * Update registration(applicant) form to course.
	 * </p>
	 * 
	 * @param id  Integer
	 * @param app ApplicantDTO
	 */
	@Override
	public void doUpdateCourseForm(Integer id, ApplicantDTO app) {
		courseDAO.dbUpdateCourseForm(id, app);
	}

	/**
	 * <h2>doDeleteCourseForm</h2>
	 * <p>
	 * Delete registration(applicant) form to course.
	 * </p>
	 * 
	 * @param id     Integer
	 * @param formId Integer
	 */
	@Override
	public void doDeleteCourseForm(Integer id, Integer formId) {
		courseDAO.dbDeleteCourseForm(id, formId);
	}

	/**
	 * <h2>doGetAllCourseName</h2>
	 * <p>
	 * Get all course name.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<String> doGetAllCourseName() {
		List<String> allcoursename = new ArrayList<String>();
		List<CourseDTO> courses = this.doGetAllCourse();
		for (CourseDTO cdto : courses) {
			allcoursename.add(cdto.getId() + " - " + cdto.getCoursename());
		}
		return allcoursename;
	}

	@Override
	public void doUpdateCourse(CourseDTO course) {
		courseDAO.dbUpdateCourse(course);
	}

	@Override
	public CourseDTO doGetCourseById(Integer id) {
		Course c = courseDAO.dbGetCourseById(id);
		return new CourseDTO(c.getId(), c.getCoursename(), c.getSchedule(), c.getPrices(), null, c.getApplicants());
	}

	@Override
	public void doSaveExcelData(List<RegistratedForm> formlists) {
		ApplicantDTO app = null;
		for (RegistratedForm form : formlists) {
			app = new ApplicantDTO(null, form.getUsername(), form.getEmail(), form.getPhone(), form.getAddress());
			this.doSaveCourseForm(form.getCourseId(), app);
		}
	}

}
