package ojt.simpletask.app.persistence.dao;

import java.util.List;

import ojt.simpletask.app.persistence.entity.course.Applicant;

/**
 * <h2>ApplicantDAO Class</h2>
 * <p>
 * Process for Displaying ApplicantDAO
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface ApplicantDAO {
	/**
	 * <h2>dbSaveApplicant</h2>
	 * <p>
	 * Save applicant.
	 * </p>
	 *
	 * @param applicant Applicant
	 * @return void
	 */
	public void dbSaveApplicant(Applicant applicant);

	/**
	 * <h2>dbGetApplicantById</h2>
	 * <p>
	 * Get applicant by id
	 * </p>
	 *
	 * @param id Integer
	 * @return
	 * @return Applicant
	 */
	public Applicant dbGetApplicantById(Integer id);

	/**
	 * <h2>getAllApplicants</h2>
	 * <p>
	 * Get all applicants.
	 * </p>
	 *
	 * @return
	 * @return List<Applicant>
	 */
	public List<Applicant> getAllApplicants();

	/**
	 * <h2>dbDeleteApplicant</h2>
	 * <p>
	 * Delete applicant.
	 * </p>
	 *
	 * @param id Integer
	 * @return void
	 */
	public void dbDeleteApplicant(Integer id);

}
