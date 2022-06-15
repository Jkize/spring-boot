package com.mvc.seccion11.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    // private String coursePrefix;
    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        this.coursePrefixes = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theCValidator) {

        if (theCode == null) {
            return true;
        }
        boolean result = false;
        for (String p : coursePrefixes) {
            result = theCode.startsWith(p);
            if (result) {
                break;
            }
        }

        return result;
    }

}