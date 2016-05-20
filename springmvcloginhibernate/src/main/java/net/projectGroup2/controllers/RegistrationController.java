package net.projectGroup2.controllers;

import org.springframework.stereotype.Controller;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.projectGroup2.form.Registration;
import net.projectGroup2.form.UploadItem;
import net.projectGroup2.model.Pictures;
import net.projectGroup2.service.LoginService;
import net.projectGroup2.service.RegistrationService;

@Controller
@RequestMapping("/registrationform.html")
public class RegistrationController {
	@Autowired
	private RegistrationValidation registrationValidation;
	
	@Autowired
	public RegistrationService registrationService;

	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) {
		System.out.println("xxxxxxx");
		Registration registration = new Registration();
	/*	Pictures pics = new Pictures();
		String x = pics.*/
		model.put("registration", registration);
		System.out.println("yyyyyyyy");
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
		public String processRegistration(@Valid Registration registration,
			BindingResult result, HttpServletRequest request, Map model) {
		HttpSession session = request.getSession();
		/*System.out.println("zzzzz"+session.getAttribute("fileName"));*/
		boolean userExists = registrationService.newUser(registration.getUserName(),registration.getPassword(),
				registration.getTags(), registration.getBiography(), registration.getEmail());
		System.out.println("111111");
		session.setAttribute("test", registration.getUserName());
		
		// set custom Validation by user
		registrationValidation.validate(registration, result);
		if(!userExists){
			registration.setUserName(registration.getUserName()+ " ALREADY EXITS!!!");
			return "registrationform";
		}
		if (result.hasErrors()) {
			System.out.println("7777777");
			return "registrationform";
		}
		else {
			System.out.println("555555");
		//return "registrationsuccess";
			return "uploadfileindex";
			/*UploadItem uploadItem = new UploadItem();
			model.put("uploadItem",uploadItem);
			return "uploadfile";*/
	}
	}
}
