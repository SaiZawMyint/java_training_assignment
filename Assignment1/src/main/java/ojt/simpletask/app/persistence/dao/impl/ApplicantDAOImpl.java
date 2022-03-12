package ojt.simpletask.app.persistence.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.simpletask.app.persistence.dao.ApplicantDAO;
import ojt.simpletask.app.persistence.entity.course.Applicant;

/**
 * <h2>ApplicantDAOImpl Class</h2>
 * <p>
 * Process for Displaying ApplicantDAOImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Repository
public class ApplicantDAOImpl implements ApplicantDAO {

	/**
	 * <h2>sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * <h2>dbSaveApplicant</h2>
	 * <p>
	 * Save applicant.
	 * </p>
	 * 
	 * @param applicant Applicant
	 */
	@Override
	public void dbSaveApplicant(Applicant applicant) {
		sessionFactory.getCurrentSession().saveOrUpdate(applicant);
	}

	/**
	 * <h2>dbGetApplicantById</h2>
	 * <p>
	 * Get applicant by id.
	 * </p>
	 * 
	 * @param id Integer
	 * @return
	 */
	@Override
	public Applicant dbGetApplicantById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Applicant applicant = null;
		try {
			String sql = "from Applicant where id = :id";
			@SuppressWarnings({ "rawtypes" })
			Query query = session.createQuery(sql);
			query.setParameter("id", id);
			applicant = (Applicant) query.getSingleResult();
		} catch (NoResultException e) {
			applicant = null;
		}
		return applicant;
	}

	/**
	 * <h2>getAllApplicants</h2>
	 * <p>
	 * Get all applicants.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<Applicant> getAllApplicants() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Applicant order by id desc", Applicant.class).getResultList();
	}

	/**
	 * <h2>dbDeleteApplicant</h2>
	 * <p>
	 * Delete applicant.
	 * </p>
	 * 
	 * @param id Integer
	 */
	@Override
	public void dbDeleteApplicant(Integer id) {
		Applicant app = sessionFactory.getCurrentSession().load(Applicant.class, id);
		if (app != null) {
			sessionFactory.getCurrentSession().delete(app);
		}
	}

}
