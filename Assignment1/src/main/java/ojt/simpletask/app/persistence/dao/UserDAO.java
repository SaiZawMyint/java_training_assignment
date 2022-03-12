package ojt.simpletask.app.persistence.dao;

import ojt.simpletask.app.persistence.entity.admin.User;

/**
 * <h2>UserDAO Class</h2>
 * <p>
 * Process for Displaying UserDAO
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface UserDAO {
	/**
	 * <h2>dbSaveUser</h2>
	 * <p>
	 * Save user.
	 * </p>
	 *
	 * @param user User
	 * @return void
	 */
	public void dbSaveUser(User user);

	/**
	 * <h2>dbGetUserByName</h2>
	 * <p>
	 * Get user by name.
	 * </p>
	 *
	 * @param username String.
	 * @return
	 * @return User
	 */
	public User dbGetUserByName(String username);

	/**
	 * <h2>dbGetUserCount</h2>
	 * <p>
	 * Get user count
	 * </p>
	 *
	 * @return
	 * @return long
	 */
	public long dbGetUserCount();
}
