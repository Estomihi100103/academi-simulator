package com.project.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "code", nullable = false, length = 255)
    private String code;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "credit", nullable = false, length = 25)
    private Integer credit;
    @Column(name = "passing_grade", nullable = true, length = 25)
    private String passingGrade;

    public Course() {
        // empty constructor
    }

    public Course(String code, String name, Integer credit, String passingGrade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.passingGrade = passingGrade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(String passingGrade) {
        this.passingGrade = passingGrade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credit + "|" + passingGrade;
    }

}
