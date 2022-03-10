package ojt.simpletask.app.web.controller;

import java.util.List;

import javax.annotation.Nullable;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.net.HttpHeaders;

import ojt.simpletask.app.bl.dto.ApplicantDTO;
import ojt.simpletask.app.bl.dto.CourseDTO;
import ojt.simpletask.app.bl.service.form.ApplicantService;
import ojt.simpletask.app.bl.service.form.CourseService;
import ojt.simpletask.app.bl.service.form.ExcelService;
import ojt.simpletask.app.common.customform.CustomForm;
import ojt.simpletask.app.web.form.excelproduct.ExcelProduct;
import ojt.simpletask.app.web.form.registration.CourseForm;
import ojt.simpletask.app.web.form.registration.RegistrationForm;

/**
 * <h2>AppController Class</h2>
 * <p>
 * Process for Displaying AppController
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
@Controller
public class AppController {
	/**
	 * <h2>model</h2>
	 * <p>
	 * model
	 * </p>
	 */
	ModelAndView model;

	/**
	 * <h2>messageSource</h2>
	 * <p>
	 * messageSource
	 * </p>
	 */
	@Autowired
	MessageSource messageSource;

	/**
	 * <h2>courseService</h2>
	 * <p>
	 * courseService
	 * </p>
	 */
	@Autowired
	CourseService courseService;

	/**
	 * <h2>applicantService</h2>
	 * <p>
	 * applicantService
	 * </p>
	 */
	@Autowired
	ApplicantService applicantService;
	/**
	 * <h2>excelService</h2>
	 * <p>
	 * excelService
	 * </p>
	 */
	@Autowired
	ExcelService excelService;

	/**
	 * <h2>coursePage</h2>
	 * <p>
	 * Home page with all course.
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/home")
	public ModelAndView coursePage() {
		model = new ModelAndView("course");
		this.defaultFormModelView("All Avaliable Course", new CustomForm("applicantForm", new CourseForm()));
		List<CourseDTO> allcourse = courseService.doGetAllCourse();
		model.addObject("courseForm", allcourse);
		model.addObject("courseList", courseService.doFetchRegistratedForm());
		return model;
	}

	/**
	 * <h2>applicant</h2>
	 * <p>
	 * Applicant action.
	 * </p>
	 *
	 * @param form CourseForm
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/applicant", method = RequestMethod.POST)
	public ModelAndView applicant(@ModelAttribute("applicantForm") CourseForm form) {
		model = new ModelAndView("registration");
		RegistrationForm reg = new RegistrationForm();
		reg.setCourseId(form.getId());
		this.defaultFormModelView("Please Fill Form", new CustomForm("infromationForm", reg));
		return model;
	}

	/**
	 * <h2>informationForm</h2>
	 * <p>
	 * Infromation form action
	 * </p>
	 *
	 * @param form   RegistrationFrom
	 * @param binder BindingResult
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView informationForm(@Valid @ModelAttribute("infromationForm") RegistrationForm form,
			BindingResult binder) {
		model = new ModelAndView();
		String message = form.getId() == null ? "M_SUCCESS_ADD" : "M_SUCCESS_EDIT";
		if (binder.hasErrors()) {
			model.setViewName("registration");
			this.defaultFormModelView("Please Fill Form", new CustomForm("infromationForm", form));
			model.addObject("systemMessage", messageSource.getMessage("M_ER_CONFIRM_DENINED", null, null));
		} else {
			ApplicantDTO appform = new ApplicantDTO(form.getId(), form.getUsername(), form.getEmail(), form.getPhone(),
					form.getAddress());
			model.setViewName("resultpage");
			if (form.getId() == null)
				courseService.doSaveCourseForm(form.getCourseId(), appform);
			else
				courseService.doUpdateCourseForm(form.getCourseId(), appform);
			model.addObject("systemMessage", messageSource.getMessage(message, null, null));
		}
		return model;
	}

	/**
	 * <h2>eidtForm</h2>
	 * <p>
	 * Edit form action
	 * </p>
	 *
	 * @param id  Integer
	 * @param cid Integer
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping("/form/edit/{id}/{cid}")
	public ModelAndView eidtForm(@PathVariable("id") Integer id, @PathVariable("cid") Integer cid) {
		model = new ModelAndView("registration");
		ApplicantDTO adto = applicantService.doGetApplicantById(id);
		RegistrationForm reg = new RegistrationForm(adto);
		reg.setCourseId(cid);
		this.defaultFormModelView("Edit Form", new CustomForm("infromationForm", reg));
		return model;
	}

	/**
	 * <h2>deleteFrom</h2>
	 * <p>
	 * Delete form action
	 * </p>
	 *
	 * @param id  Integer
	 * @param cid Integer
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping("/form/delete/{id}/{cid}")
	public ModelAndView deleteFrom(@PathVariable("id") Integer id, @PathVariable("cid") Integer cid) {
		model = new ModelAndView("resultpage");
		if (applicantService.doGetApplicantById(id) != null) {
			courseService.doDeleteCourseForm(cid, id);
			model.addObject("systemMessage", messageSource.getMessage("M_SUCCESS_DELETE", null, null));
		} else {
			model.addObject("systemMessage", messageSource.getMessage("M_ER_ACCESS_DENINED", null, null));
		}
		return model;
	}

	/**
	 * <h2>uploadExcel</h2>
	 * <p>
	 * Upload excel.
	 * </p>
	 *
	 * @param product ExcelProduct
	 * @param binder  BindingResult
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	public ModelAndView uploadExcel(@Valid @ModelAttribute("fileupload") ExcelProduct product, BindingResult binder) {
		model = new ModelAndView("resultpage");
		return model;
	}

	@RequestMapping(value = "/downloadallcourse")
	public ResponseEntity<InputStreamResource> downloadProduct() {
		String filename = "test.xlsx";
		InputStreamResource fileinp = new InputStreamResource(excelService.doDownlaodCourse());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(fileinp);
	}

	/**
	 * <h2>defaultFormModelView</h2>
	 * <p>
	 * Default model and view
	 * </p>
	 *
	 * @param title String
	 * @param form  CustomForm
	 * @return void
	 */
	public void defaultFormModelView(String title, @Nullable CustomForm form) {
		model.addObject("title", title);
		model.addObject("courseList");
		if (!form.isNull() && form != null) {
			model.addObject(form.getName(), form.getForm());
		}
	}
}
