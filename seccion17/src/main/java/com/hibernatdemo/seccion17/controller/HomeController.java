package com.hibernatdemo.seccion17.controller;

import com.hibernatdemo.seccion17.entity.CourseEntity;
import com.hibernatdemo.seccion17.entity.InstructorDetailEntity;
import com.hibernatdemo.seccion17.entity.InstructorEntity;
import com.hibernatdemo.seccion17.entity.ReviewEntity;
import com.hibernatdemo.seccion17.entity.StudentEntity;
import com.hibernatdemo.seccion17.repository.CourseRepository;
import com.hibernatdemo.seccion17.repository.InstructorDetailRepository;
import com.hibernatdemo.seccion17.repository.InstructorRepository;
import com.hibernatdemo.seccion17.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    StudentRepository repoStudent; // Not a good way. We have to have a services communication

    @Autowired
    InstructorRepository repoInstructor;

    @Autowired
    InstructorDetailRepository repoInstructorDetail;

    @Autowired
    CourseRepository repoCourse;

    @GetMapping("/saveOneToOne")
    public void saveOneToOne() {

        // The cascade save all the childs
        InstructorEntity tempInstructor = new InstructorEntity("Jhoan", "Saavedra", "sebas@gmail.com");
        InstructorDetailEntity tempInstructordetail = new InstructorDetailEntity("http://www.jhosesaro.com",
                "Hey what's up");
        tempInstructor.setInstructorDetail(tempInstructordetail);

        repoInstructor.save(tempInstructor);

        // InstructorEntity newF = repoInstructor.getById(1);

    }

    @GetMapping("/deleteOneToOne")
    public void deleteOneToOne() {

        // it works in both way. It's very important the type of cascade with that point
        // we can delete, update the data ;)
        // it work by id or by object

        InstructorEntity newF = repoInstructor.getById(1);
        repoInstructor.delete(newF);

        // repoInstructor.deleteById(2);

    }

    @GetMapping("/getOneToOneBiderectional")
    public ResponseEntity<Object> getOneToOneBiderectional() {
        // InstructorEntity ab = repoInstructor.getById(4);
        // System.out.println(ab);
        // This make a loop :()
        // it's good to put try catch when there's not match by id
        // Delete is the same
        InstructorDetailEntity detail = repoInstructorDetail.getById(3);
        System.out.println("\n Details" + detail + "Instructor" + detail.getInstructorEntity().toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>("Hello Wolrd", httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/oneToMany")
    public ResponseEntity<Object> oneToMany() {
        /*
         * Step 1
         * InstructorEntity tempInstructor = new InstructorEntity("Susan", "Public",
         * "susan.public@luv2.com");
         * InstructorDetailEntity tempIDetail = new
         * InstructorDetailEntity("www.youtube.com", "Video games");
         * tempInstructor.setInstructorDetail(tempIDetail);
         * repoInstructor.save(tempInstructor);
         */

        /*
         * Step 2
         * InstructorEntity tempI = repoInstructor.getById(4);
         * 
         * tempI.add(new CourseEntity("Matemáticas"));
         * 
         * tempI.add(new CourseEntity("Sociales"));
         * 
         * tempI.add(new CourseEntity("Ciencias"));
         * 
         * tempI.add(new CourseEntity("Programación"));
         * repoInstructor.save(tempI);
         * 
         * //The step 1 and 2 can be in one step if We want ;)
         */

        InstructorEntity tempI = repoInstructor.getById(4);
        System.out.println(tempI);
        System.out.println("\n LoadingLazy");
        System.out.println("The other " + tempI.getListCourse().get(0));
        System.out.println(tempI.getListCourse().get(1));

        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>("Hello Wolrd", httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/oneToManyUni")
    public ResponseEntity<Object> oneToManyUni() {

        /*
         **** Add Course with reviews
         * CourseEntity tempCourse = new CourseEntity("Another Couse of Pacman");
         * tempCourse.addReview(new ReviewEntity("Great, I love it "));
         * tempCourse.addReview(new ReviewEntity("Great, I love it "));
         * tempCourse.addReview(new ReviewEntity("Great, I love it "));
         * tempCourse.addReview(new ReviewEntity("I only want to say xD"));
         * tempCourse.addReview(new ReviewEntity("What happend here xD"));
         * 
         * repoCourse.save(tempCourse);
         * System.out.println(tempCourse); print also the id correctly :3
         * 
         */

        /*
         * Get course ;)
         * CourseEntity tempCourse = repoCourse.getById(18);
         * System.out.println(tempCourse);
         * System.out.println(tempCourse.getReviews());
         * 
         */

        // Delete course
        repoCourse.deleteById(18);

        return new ResponseEntity<>("Hello Wolrd", new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/manyToMany_course")
    public ResponseEntity<Object> manyToManyCourse() {

        CourseEntity tempCourse = new CourseEntity("Hello WOrld Course");
        tempCourse.addStudent(new StudentEntity("Jhoan", "XD", "email@gmail.com"));

        tempCourse.addStudent(new StudentEntity("Jorge", "XD", "email@gmail.com"));

        tempCourse.addStudent(new StudentEntity("Sebastian", "XD", "email2@gmail.com"));

        tempCourse.addStudent(new StudentEntity("Saavedra", "XD", "email3@gmail.com"));
        repoCourse.save(tempCourse);

        return new ResponseEntity<>("Hello Wolrd", new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/manyToMany_student")
    public ResponseEntity<Object> manyToManyStudent() {

        StudentEntity student = new StudentEntity("Ana Lucía Calderon", "XD", "email@gmail.com");
        student.addCourse(new CourseEntity("Curso 1"));
        student.addCourse(new CourseEntity("Curso 2"));
        student.addCourse(new CourseEntity("Curso 3"));
        student.addCourse(new CourseEntity("Curso 4"));

        repoStudent.save(student);

        return new ResponseEntity<>("Hello Wolrd", new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/manyToMany_get")
    public ResponseEntity<Object> manyToManyGet() {

        StudentEntity student = repoStudent.getById(6);
        CourseEntity course = repoCourse.getById(19);

        System.out.println("\n\n" + student + " courses " + student.getListCourses() + "\n\n");
        System.out.println(course + " students " + course.getListStudents());

        return new ResponseEntity<>("Hello Wolrd", new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/manyToMany_delete")
    public void delteManyToMany() {
        /**
         * When we delete a course, it's only delted the course and the relation in
         * course_student but not the student
         * this is the same case when we delete a student
         */

        repoCourse.deleteById(20);
    }
}
