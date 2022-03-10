package ojt.simpletask.app.bl.service.form;

import ojt.simpletask.app.bl.dto.ApplicantDTO;

/**
 * <h2> ApplicantService Class</h2>
 * <p>
 * Process for Displaying ApplicantService
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface ApplicantService {
	/**
	 * <h2> doGetApplicantById</h2>
	 * <p>
	 * Get applicant by id.
	 * </p>
	 *
	 * @param id Integer
	 * @return
	 * @return ApplicantDTO
	 */
	public ApplicantDTO doGetApplicantById(Integer id);
	/**
	 * <h2> doDeleteApplicant</h2>
	 * <p>
	 * Delete applicant.
	 * </p>
	 *
	 * @param id Integer
	 * @return void
	 */
	public void doDeleteApplicant(Integer id);
}
