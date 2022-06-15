package com.hibernatdemo.seccion17.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class InstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetailEntity instructorDetail;

    @OneToMany(mappedBy = "instructor", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    private List<CourseEntity> listCourse;

    public InstructorEntity() {

    }

    public InstructorEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetailEntity getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetailEntity instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<CourseEntity> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<CourseEntity> listCourse) {
        this.listCourse = listCourse;
    }

    @Override
    public String toString() {
        return "InstructorEntity [email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName
                + "]";
    }

    public void add(CourseEntity tempCourse){
        if(this.listCourse==null){
            this.listCourse = new ArrayList<>();
        }
        this.listCourse.add(tempCourse);
        tempCourse.setInstructor(this);
    }

}
