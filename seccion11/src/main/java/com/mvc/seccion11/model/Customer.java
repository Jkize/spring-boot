package com.mvc.seccion11.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mvc.seccion11.validators.CourseCode;

public class Customer {

    private String firstName;

    @NotNull(message = "Is required")
    @Size(min = 1, message = "Min is 1")
    private String lastName;

    
    @NotNull(message = "Is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePassess;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 char/digits")
    private String postalCode;

    //@CourseCode(value = "LOL", message = "it must start with LOL")
    @CourseCode(value={"TOPS", "LUV"}, message="must start with TOPS or LUV")
    private String courseCode;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePassess() {
        return freePassess;
    }

    public void setFreePassess(Integer freePassess) {
        this.freePassess = freePassess;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    
    
}
