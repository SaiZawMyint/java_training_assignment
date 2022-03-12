package ojt.simpletask.app.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.simpletask.app.persistence.dao.AuthorityDAO;
import ojt.simpletask.app.persistence.entity.admin.Authorities;

/**
 * <h2>AuthorityDAOImpl Class</h2>
 * <p>
 * Process for Displaying AuthorityDAOImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Transactional
@Repository
public class AuthorityDAOImpl implements AuthorityDAO {

	/**
	 * <h2>sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <h2>dbSaveAuthority</h2>
	 * <p>
	 * Save Authority.
	 * </p>
	 * 
	 * @param authority Authorities
	 */
	@Override
	public void dbSaveAuthority(Authorities authority) {
		this.sessionFactory.getCurrentSession().save(authority);
	}

	/**
	 * <h2>dbGetAuthorityCount</h2>
	 * <p>
	 * Get authority count.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public long dbGetAuthorityCount() {
		@SuppressWarnings("rawtypes")
		Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(a) FROM Authorities a");
		return (long) query.getSingleResult();
	}

}
