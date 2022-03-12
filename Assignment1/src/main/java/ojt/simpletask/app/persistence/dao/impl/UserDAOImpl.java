package ojt.simpletask.app.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.simpletask.app.persistence.dao.UserDAO;
import ojt.simpletask.app.persistence.entity.admin.User;

/**
 * <h2>UserDAOImpl Class</h2>
 * <p>
 * Process for Displaying UserDAOImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	/**
	 * <h2>sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <h2>dbSaveUser</h2>
	 * <p>
	 * Save user
	 * </p>
	 * 
	 * @param user User
	 */
	@Override
	public void dbSaveUser(User user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(user);
	}

	/**
	 * <h2>dbGetUserByName</h2>
	 * <p>
	 * Get user by name.
	 * </p>
	 * 
	 * @param username String
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public User dbGetUserByName(String username) {
		Query query = this.sessionFactory.getCurrentSession()
				.createQuery("SELECT u FROM User u WHERE u.username = :username");
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}

	/**
	 * <h2>dbGetUserCount</h2>
	 * <p>
	 * Get user count.
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public long dbGetUserCount() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
		return (long) query.getSingleResult();
	}
}
