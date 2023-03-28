package com.elMawqe3.Configurations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.elMawqe3.Models.UserDto;

public class PassValidator implements ConstraintValidator<PasswordMatches,Object>{


	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		 UserDto user = (UserDto) obj;
	        return user.getPassword().equals(user.getMatchingPassword());
	}

}
