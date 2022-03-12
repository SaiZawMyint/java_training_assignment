package ojt.simpletask.app.bl.service.form.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.simpletask.app.bl.dto.CustomUserDetatils;
import ojt.simpletask.app.bl.service.form.UserService;
import ojt.simpletask.app.persistence.dao.UserDAO;
import ojt.simpletask.app.persistence.entity.admin.User;

/**
 * <h2>UserServiceImpl Class</h2>
 * <p>
 * Process for Displaying UserServiceImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Transactional
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	/**
	 * <h2>userDAO</h2>
	 * <p>
	 * userDAO
	 * </p>
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * <h2>loadUserByUsername</h2>
	 * <p>
	 * Load user by username.
	 * </p>
	 * 
	 * @param username String
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userInfo = this.userDAO.dbGetUserByName(username);
		if (userInfo == null) {
			throw new UsernameNotFoundException("Invalid Username or Password!");
		}
		UserDetails user = new CustomUserDetatils(userInfo.getUsername(), userInfo.getPassword(),
				userInfo.getAuthorities());
		return user;
	}

	/**
	 * <h2>doGetUserByName</h2>
	 * <p>
	 * Get user by name.
	 * </p>
	 * 
	 * @param username String
	 * @return
	 */
	@Override
	public User doGetUserByName(String username) {
		return userDAO.dbGetUserByName(username);
	}

	/**
	 * <h2>doGetUserCount</h2>
	 * <p>
	 * Get user count.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public long doGetUserCount() {
		return userDAO.dbGetUserCount();
	}

	/**
	 * <h2>isHasAccess</h2>
	 * <p>
	 * Check for access.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public boolean isHasAccess() {
		boolean access = false;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			access = auth.getName().equalsIgnoreCase("admin") ? true : false;
		}
		return access;
	}
}
