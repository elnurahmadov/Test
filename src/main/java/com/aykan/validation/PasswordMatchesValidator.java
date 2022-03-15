package com.aykan.validation;

import com.aykan.web.dto.PasswordDto;
import com.aykan.web.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj.getClass().getSimpleName().equals("UserDto")) {
            UserDto userDto = (UserDto) obj;
            return userDto.getPassword().equals(userDto.getMatchingPassword());
        } else {
            PasswordDto passwordDto = (PasswordDto) obj;
            return passwordDto.getNewPassword().equals(passwordDto.getMatchingNewPassword());
        }
    }
}
