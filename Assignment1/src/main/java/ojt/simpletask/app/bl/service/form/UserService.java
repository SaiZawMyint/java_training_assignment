package ojt.simpletask.app.bl.service.form;

import ojt.simpletask.app.persistence.entity.admin.User;

/**
 * <h2>UserService Class</h2>
 * <p>
 * Process for Displaying UserService
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface UserService {
	/**
	 * <h2>doGetUserByName</h2>
	 * <p>
	 * Get user by name.
	 * </p>
	 *
	 * @param username String
	 * @return
	 * @return User
	 */
	public User doGetUserByName(String username);

	/**
	 * <h2>doGetUserCount</h2>
	 * <p>
	 * Get user count.
	 * </p>
	 *
	 * @return
	 * @return long
	 */
	public long doGetUserCount();

	/**
	 * <h2>isHasAccess</h2>
	 * <p>
	 * Check for access.
	 * </p>
	 *
	 * @return
	 * @return boolean
	 */
	public boolean isHasAccess();
}
