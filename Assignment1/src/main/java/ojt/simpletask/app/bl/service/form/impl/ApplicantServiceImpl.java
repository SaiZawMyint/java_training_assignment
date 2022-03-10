package ojt.simpletask.app.bl.service.form.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.bl.service.form.ApplicantService;
import ojt.simpletask.app.persistence.dao.ApplicantDAO;
import ojt.simpletask.app.persistence.entity.course.Applicant;

/**
 * <h2>ApplicantServiceImpl Class</h2>
 * <p>
 * Process for Displaying ApplicantServiceImpl
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Transactional
@Service
public class ApplicantServiceImpl implements ApplicantService {

	/**
	 * <h2>applicantDAO</h2>
	 * <p>
	 * applicantDAO
	 * </p>
	 */
	@Autowired
	private ApplicantDAO applicantDAO;

	/**
	 * <h2>doGetApplicantById</h2>
	 * <p>
	 * Get registration(applicant) from by id.
	 * </p>
	 * 
	 * @param id Integer
	 * @return
	 */
	@Override
	public ApplicantDTO doGetApplicantById(Integer id) {
		Applicant app = applicantDAO.dbGetApplicantById(id);
		return new ApplicantDTO(app.getId(), app.getUsername(), app.getEmail(), app.getPhonenumber(), app.getAddress());
	}

	/**
	 * <h2>doDeleteApplicant</h2>
	 * <p>
	 * Delete registration(applicant) from.
	 * </p>
	 * 
	 * @param id Integer
	 */
	@Override
	public void doDeleteApplicant(Integer id) {
		applicantDAO.dbDeleteApplicant(id);
	}
}
