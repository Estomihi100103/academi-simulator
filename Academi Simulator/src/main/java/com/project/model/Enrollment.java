package com.project.model;

import java.util.*;
import javax.persistence.*;



@Entity
@Table(name = "enrollment")
public class Enrollment {
    private static int nextId = 1;

    @Id
    @Column(name = "id", nullable = false, length = 25)
    private int id = 0;

    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @Column(name = "academic_year", nullable = false, length = 25)
    private String academicYear;

    @Column(name = "semester", nullable = false, length = 25)
    private String semester;

    @Column(name = "grade", nullable = true, length = 25)
    private String grade;

    public Enrollment() {
        // empty constructor
    }

    public Enrollment(Course course, Student student, String academicYear, String semester, String grade) {

        this.course = course;
        this.student = student;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    public Enrollment(Course course, Student student, String academicYear, String semester) {
        this.id = nextId++;
        this.course = course;
        this.student = student;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "none";
    }

    // Hapus getter dan setter untuk properti id

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return course.getCode() + "|" + student.getStudentId() + "|" + academicYear + "|" + semester + "|" + grade;
    }
}