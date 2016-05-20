/*package net.projectGroup2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import net.projectGroup2.form.CreatePost;


@Component("createValidator")
public class CreatePostValidation {
	public boolean supports(Class<?> klass) {
		return CreatePost.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		CreatePost createpost = (CreatePost) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.registration.userName",
				"User Name must not be Empty.");
		String userName = createpost.getUserName();
		if ((userName.length()) > 50) {
			errors.rejectValue("userName",
					"lengthOfUser.registration.userName",
					"User Name must not more than 50 characters.");
		}
		if (!(createpost.getPassword()).equals(createpost
				.getConfirmPassword())) {
			errors.rejectValue("password",
					"matchingPassword.registration.password",
					"Password and Confirm Password Not match.");
		}
	}

*/