package me.wony.springapplicationcontext;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Test.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","notempty","name is not empty");
    }
}
