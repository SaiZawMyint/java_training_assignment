package ojt.simpletask.app.persistence.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.bl.dto.CourseDTO;
import ojt.simpletask.app.persistence.dao.CourseDAO;
import ojt.simpletask.app.persistence.entity.course.Applicant;
import ojt.simpletask.app.persistence.entity.course.Course;
import ojt.simpletask.app.web.form.registration.RegistratedForm;

/**
 * <h2>CourseDAOImpl Class</h2>
 * <p>
 * Process for Displaying CourseDAOImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Repository
public class CourseDAOImpl implements CourseDAO {

	/**
	 * <h2>sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * <h2>dbGetAllCourse</h2>
	 * <p>
	 * Get all course.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<Course> dbGetAllCourse() {
		return this.sessionFactory.getCurrentSession().createQuery("from Course order by id desc", Course.class)
				.getResultList();
	}

	/**
	 * <h2>dbGetCourseById</h2>
	 * <p>
	 * Get course by id.
	 * </p>
	 * 
	 * @param id Integer
	 * @return
	 */
	@Override
	public Course dbGetCourseById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Course course = null;
		try {
			String sql = "from Course where id = :id";
			@SuppressWarnings({ "rawtypes" })
			Query query = session.createQuery(sql);
			query.setParameter("id", id);
			course = (Course) query.getSingleResult();
		} catch (NoResultException e) {
			course = null;
		}
		return course;
	}

	/**
	 * <h2>dbFetchRegistratedForm</h2>
	 * <p>
	 * Fetch all registrated froms.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<RegistratedForm> dbFetchRegistratedForm() {
		List<Course> course = this.dbGetAllCourse();
		List<RegistratedForm> result = new ArrayList<RegistratedForm>();
		RegistratedForm r = null;
		for (Course c : course) {
			if (c.getApplicants().size() > 0) {
				for (Applicant a : c.getApplicants()) {
					r = new RegistratedForm();
					r.setUserid(a.getId());
					r.setCourseId(c.getId());
					r.setUsername(a.getUsername());
					r.setCoursename(c.getCoursename());
					r.setEmail(a.getEmail());
					r.setPhone(a.getPhonenumber());
					r.setAddress(a.getAddress());
					result.add(r);
				}
			}
		}
		return result;
	}

	/**
	 * <h2>dbSaveCourseForm</h2>
	 * <p>
	 * Save course form.
	 * </p>
	 * 
	 * @param id  Integer
	 * @param app Applicant
	 */
	@Override
	public void dbSaveCourseForm(Integer id, ApplicantDTO app) {
		Course c = this.dbGetCourseById(id);
		c.getApplicants()
				.add(new Applicant(app.getId(), app.getUsername(), app.getEmail(), app.getPhone(), app.getAddress()));
		sessionFactory.getCurrentSession().saveOrUpdate(c);
	}

	/**
	 * <h2>dbUpdateCourseForm</h2>
	 * <p>
	 * Update course form
	 * </p>
	 * 
	 * @param id  Integer
	 * @param app Applicant
	 */
	@Override
	public void dbUpdateCourseForm(Integer id, ApplicantDTO app) {
		Course c = this.dbGetCourseById(id);
		this.triggerExistence(c, app.getId());
		c.getApplicants()
				.add(new Applicant(app.getId(), app.getUsername(), app.getEmail(), app.getPhone(), app.getAddress()));
		sessionFactory.getCurrentSession().merge(c);
	}

	/**
	 * <h2>dbDeleteCourseForm</h2>
	 * <p>
	 * Delete course form
	 * </p>
	 * 
	 * @param id     Integer
	 * @param formId Integer
	 */
	@Override
	public void dbDeleteCourseForm(Integer id, Integer formId) {
		Course c = this.dbGetCourseById(id);
		this.triggerExistence(c, formId);
		sessionFactory.getCurrentSession().merge(c);
		sessionFactory.getCurrentSession().flush();
	}

	/**
	 * <h2>triggerExistence</h2>
	 * <p>
	 * Trigger existed applicant from couse and remove them to up to date.
	 * </p>
	 *
	 * @param c         Course
	 * @param relatedId Integer
	 * @return void
	 */
	private void triggerExistence(Course c, Integer relatedId) {
		for (Applicant a : c.getApplicants()) {
			if (a.getId() == relatedId) {
				c.getApplicants().remove(a);
				break;
			}
		}
	}

	/**
	 * <h2>dbSaveAllCourse</h2>
	 * <p>
	 * Save all Corse
	 * </p>
	 * 
	 * @param courses
	 */
	@Override
	public void dbSaveAllCourse(List<Course> courses) {
		for (Course c : courses) {
			System.out.println("course name : "+c.getCoursename());
			sessionFactory.getCurrentSession().saveOrUpdate(c);
		}
	}

	/**
	 * <h2>dbGetCourseByAppId</h2>
	 * <p>
	 * Get Corse by applicant id (fetch joined table child to parent);
	 * </p>
	 * 
	 * @param appid Integer
	 * @return
	 */
	@Override
	public Course dbGetCourseByAppId(Integer appid) {
		List<Course> courselist = this.dbGetAllCourse();
		List<Course> res = new ArrayList<Course>();
		A: for (Course course : courselist) {
			for (Applicant a : course.getApplicants()) {
				if (a.getId() == appid) {
					res.add(course);
					break A;
				}
			}
		}
		return res.get(0);
	}

	@Override
	public Course dbGetCourseByName(String name) {
		String hql = "From Course c where c.coursename = :name";
		Course c = null;
		try {
			@SuppressWarnings("rawtypes")
			Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
			q.setParameter("name", name);
			c = (Course) q.getSingleResult();
		} catch (NoResultException e) {
			c = null;
		}
		return c;
	}

	/**
	 * <h2> dbSaveOrUpdateMultipalCourses </h2>
	 * <p>
	 * Save multiple courses.
	 * </p>
	 * 
	 * @param courses
	 */
	@Override
	public void dbSaveOrUpdateMultipalCourses(List<Course> courses) {
		for(Course c:courses) {
			this.sessionFactory.getCurrentSession().saveOrUpdate(c);
		}
	}

	/**
	 * <h2> dbSaveCourse </h2>
	 * <p>
	 * Save course.
	 * </p>
	 * 
	 * @param c Course
	 */
	@Override
	public void dbSaveCourse(Course c) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(c);
	}

	@Override
	public void dbUpdateCourse(CourseDTO c) {
		Course course = this.dbGetCourseById(c.getId());
		course.setCoursename(c.getCoursename());
		course.setSchedule(c.getSchedule());
		course.setPrices(c.getPrice());
		course.setPostdate(LocalDate.now());
		this.sessionFactory.getCurrentSession().update(course);
	}

	/**
	 * <h2> dbDeleteCourse </h2>
	 * <p>
	 * Delete Course.
	 * </p>
	 * 
	 * @param id
	 */
	@Override
	public void dbDeleteCourse(Integer id) {
		Course c = this.dbGetCourseById(id);
		this.sessionFactory.getCurrentSession().delete(c);
	}
}
