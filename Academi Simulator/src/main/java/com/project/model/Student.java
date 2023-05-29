package com.project.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id", nullable = false, length = 255)
    private String studentId;

    @Column(name = "student_name", nullable = false, length = 255)
    private String studentName;

    @Column(name = "study_program", nullable = false, length = 25)
    private String studyProgram;

    @Column(name = "academic_year", nullable = false, length = 25)
    private String academicYear;

    @Column(name = "gpa", nullable = true, length = 25)
    private Double gpa;

    public Student() {
        // empty constructor
    }

    public Student(String studentId, String studentName, String year, String studyProgram) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.academicYear = year;
        this.studyProgram = studyProgram;
        this.gpa = 0.0;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getYear() {
        return academicYear;
    }

    public void setYear(String year) {
        this.academicYear = year;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    @Override
    public String toString() {
        if (gpa == null) {
            return studentId + "|" + studentName + "|" + academicYear + "|" + studyProgram;
        } else {
            return studentId + "|" + studentName + "|" + academicYear + "|" + studyProgram + "|" + gpa;
        }
    }

}
