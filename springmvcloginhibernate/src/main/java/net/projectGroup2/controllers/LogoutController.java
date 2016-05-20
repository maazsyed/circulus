/*
 * Created by: Maaz Syed
 * Date: 4/25/2016 2:44am
 */
package net.projectGroup2.controllers;

import org.springframework.stereotype.Controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.Registration;
import net.projectGroup2.form.UploadItem;
import net.projectGroup2.model.Pictures;
import net.projectGroup2.service.LoginService;
import net.projectGroup2.service.RegistrationService;

@Controller
@RequestMapping("logout.html")
public class LogoutController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Enumeration<String> sessionAttr = session.getAttributeNames();

		while (sessionAttr.hasMoreElements()) {
			String attrName = sessionAttr.nextElement();
			session.removeAttribute(attrName);
		}
		
		session.invalidate();
		
		//session.setAttribute("username", "maaz");
		//session.removeAttribute("username");
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}
}
