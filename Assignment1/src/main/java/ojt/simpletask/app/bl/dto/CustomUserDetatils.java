package ojt.simpletask.app.bl.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ojt.simpletask.app.persistence.entity.admin.Authorities;

/**
 * <h2>CustomUserDetatils Class</h2>
 * <p>
 * Process for Displaying CustomUserDetatils
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetatils implements UserDetails {
	/**
	 * <h2>serialVersionUID</h2>
	 * <p>
	 * serialVersionUID
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <h2>username</h2>
	 * <p>
	 * username
	 * </p>
	 */
	private String username;
	/**
	 * <h2>password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	private String password;
	/**
	 * <h2>authorities</h2>
	 * <p>
	 * authorities
	 * </p>
	 */
	private List<Authorities> authorities;

	/**
	 * <h2>getAuthorities</h2>
	 * <p>
	 * Get current authorities.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		for (Authorities authority : this.authorities) {
			list.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return list;
	}

	/**
	 * <h2>isAccountNonExpired</h2>
	 * <p>
	 * Check account expried or not.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * <h2>isAccountNonLocked</h2>
	 * <p>
	 * Check accrountNotLocked.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * <h2>isCredentialsNonExpired</h2>
	 * <p>
	 * Check credentialsNonExpired.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * <h2>isEnabled</h2>
	 * <p>
	 * Check isEnabled.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * <h2>getPassword</h2>
	 * <p>
	 * Get password.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public String getPassword() {
		return this.password;
	}

	/**
	 * <h2>getUsername</h2>
	 * <p>
	 * Get username.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public String getUsername() {
		return this.username;
	}
}
