package ojt.simpletask.app.persistence.dao;

import ojt.simpletask.app.persistence.entity.admin.Authorities;

/**
 * <h2> AuthorityDAO Class</h2>
 * <p>
 * Process for Displaying AuthorityDAO
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface AuthorityDAO {
	/**
	 * <h2> dbSaveAuthority</h2>
	 * <p>
	 *	Save authorities.
	 * </p>
	 *
	 * @param authority Authorities
	 * @return void
	 */
	public void dbSaveAuthority(Authorities authority);

    /**
     * <h2> dbGetAuthorityCount</h2>
     * <p>
     * Get authorities count.
     * </p>
     *
     * @return
     * @return long
     */
    public long dbGetAuthorityCount();
}
