package com.mvc.seccion11.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD }) // Can apply our annotation ot a method or field
@Retention(RetentionPolicy.RUNTIME) // Retain thes annotation in the java class file process it at runtime
public @interface CourseCode {

    // public String value() default "LUV";

    public String[] value() default { "LUV" };

    public String message() default "must start with LUV";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
