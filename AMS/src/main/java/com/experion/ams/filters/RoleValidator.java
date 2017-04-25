package com.experion.ams.filters;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.experion.ams.mvc.data.RoleForm;

public class RoleValidator implements Validator {

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return RoleForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RoleForm roleForm = (RoleForm) target;
		if (roleForm.getName().equalsIgnoreCase(null)
				&& roleForm.getName().equals("0")) {

			errors.rejectValue("rolename", "name should not be empty");
		} else if (roleForm.getName().matches("/^[A-Za-z]+$/")) {
			errors.rejectValue("rolename", "name should be alphabets");
		}

	}

}