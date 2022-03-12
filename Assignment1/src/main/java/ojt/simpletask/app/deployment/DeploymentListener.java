package ojt.simpletask.app.deployment;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ojt.simpletask.app.persistence.dao.AuthorityDAO;
import ojt.simpletask.app.persistence.dao.UserDAO;
import ojt.simpletask.app.persistence.entity.admin.Authorities;
import ojt.simpletask.app.persistence.entity.admin.User;


/**
 * <h2>DeploymentListener Class</h2>
 * <p>
 * Process for Displaying DeploymentListener
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Component
public class DeploymentListener {

	/**
	 * <h2>passwordEncoder</h2>
	 * <p>
	 * passwordEncoder
	 * </p>
	 */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * <h2>authorityDAO</h2>
	 * <p>
	 * authorityDAO
	 * </p>
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * <h2>userDAO</h2>
	 * <p>
	 * userDAO
	 * </p>
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * <h2>addInitialData</h2>
	 * <p>
	 * Add initial data.
	 * </p>
	 *
	 * @return void
	 */
	@PostConstruct
	public void addInitialData() {
		// adding default data
		if (this.authorityDAO.dbGetAuthorityCount() <= 0 && this.userDAO.dbGetUserCount() <= 0) {
			List<Authorities> adminAuthorities = new ArrayList<Authorities>();
			Authorities adminAuthority = new Authorities(null, "ROLE_ADMIN");
			this.authorityDAO.dbSaveAuthority(adminAuthority);
			adminAuthorities.add(adminAuthority);
			User admin = new User(null, "admin", passwordEncoder.encode("123"), adminAuthorities);
			this.userDAO.dbSaveUser(admin);

			List<Authorities> userAuthorities = new ArrayList<Authorities>();
			Authorities userAuthority = new Authorities(null, "ROLE_USER");
			this.authorityDAO.dbSaveAuthority(userAuthority);
			userAuthorities.add(userAuthority);
			User user = new User(null, "user", passwordEncoder.encode("123"), userAuthorities);
			this.userDAO.dbSaveUser(user);
		}
	}
}
