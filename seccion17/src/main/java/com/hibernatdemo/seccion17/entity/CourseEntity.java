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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructor;

    @OneToMany(cascade = CascadeType.ALL) // Default one to many is fetch=FetchType.LAZY
    @JoinColumn(name = "course_id")
    private List<ReviewEntity> listReviews;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> listStudents;

    public CourseEntity() {

    }

    public CourseEntity(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    public List<ReviewEntity> getReviews() {
        return listReviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.listReviews = reviews;
    }

    public void addReview(ReviewEntity review) {
        if (listReviews == null) {
            listReviews = new ArrayList<>();
        }
        listReviews.add(review);
    }

    public List<ReviewEntity> getListReviews() {
        return listReviews;
    }

    public void setListReviews(List<ReviewEntity> listReviews) {
        this.listReviews = listReviews;
    }

    public List<StudentEntity> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<StudentEntity> listStudents) {
        this.listStudents = listStudents;
    }

    public void addStudent(StudentEntity student) {
        if (this.listStudents == null) {
            this.listStudents = new ArrayList<>();
        }
        listStudents.add(student);
    }

    @Override
    public String toString() {
        return "CourseEntity [id=" + id + ", title=" + title + "]";
    }

}
