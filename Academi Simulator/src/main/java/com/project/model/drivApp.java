package com.project.model;

import java.util.*;

import javax.persistence.*;

public class drivApp {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;
    public static ArrayList<Course> containerCourses = new ArrayList<Course>();
    public static ArrayList<Student> containerStudents = new ArrayList<Student>();

    public static void initializeEntityManager() {
        factory = Persistence.createEntityManagerFactory("course_pu");
        entityManager = factory.createEntityManager();
    }

    public static void cleanTableCourse() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Course c").executeUpdate();
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public static void cleanTableStudent() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Student s").executeUpdate();
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public static void cleanTableEnrollment() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Enrollment e").executeUpdate();
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public static void createCourse(String code, String name, Integer credit, String passingGrade) {

        boolean cek = false;
        for (Course course : containerCourses) {
            if (course.getCode().equals(code)) {
                cek = true;
                break;
            }
        }
        if (cek == false) {
            Course newCourse = new Course(code, name, credit, passingGrade);
            containerCourses.add(newCourse);
            entityManager.getTransaction().begin();
            entityManager.persist(newCourse);
            entityManager.flush();
            entityManager.getTransaction().commit();

        }
    }

    public static void ShowCourse() {
        String query = "SELECT c FROM Course c";
        List<Course> courses = entityManager.createQuery(query, Course.class)
                .getResultList();

        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

    // student-add#12S20999#Wiro Sableng#2020#Information Systems
    public static void CreateStudent(String studentId, String name, String academicYear, String studyProgram) {
        boolean cek = false;
        for (Student student : containerStudents) {
            if (student.getStudentId().equals(studentId)) {
                cek = true;
                break;
            }
        }
        if (cek == false) {
            Student newStudent = new Student(studentId, name, academicYear, studyProgram);
            containerStudents.add(newStudent);
            entityManager.getTransaction().begin();
            entityManager.persist(newStudent);
            entityManager.flush();
            entityManager.getTransaction().commit();

        }
    }

    public static void ShowStudent() {
        String query = "SELECT s FROM Student s";
        List<Student> students = entityManager.createQuery(query, Student.class)
                .getResultList();

        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    // enrollment-add#12S2203#12S20111#2020/2021#even
    public static void createEnrollment(String courseCode, String studentId, String year, String semester) {
        for (Course course : containerCourses) {
            if (course.getCode().equals(courseCode)) {
                for (Student student : containerStudents) {
                    if (student.getStudentId().equals(studentId)) {
                        Enrollment newEnrollment = new Enrollment(course, student, year, semester);
                        entityManager.getTransaction().begin();
                        entityManager.persist(newEnrollment);
                        entityManager.flush();
                        entityManager.getTransaction().commit();
                    }
                }
            }
        }

    }

    public static void ShowEnrollment() {
        String query = "SELECT e FROM Enrollment e";
        List<Enrollment> enrollments = entityManager.createQuery(query, Enrollment.class)
                .getResultList();

        for (Enrollment e : enrollments) {
            System.out.println(e.toString());
        }
    }

    // enrollment-grade#12S2102#12S20002#2021/2022#odd#AB
    public static void setGrade(String courseCode, String studentId, String year, String semester, String grade) {
        initializeEntityManager(); // Tambahkan ini untuk inisialisasi objek entityManager
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Enrollment e SET e.grade = :grade " +
                "WHERE e.course.code = :courseCode " +
                "AND e.student.studentId = :studentId " +
                "AND e.academicYear = :year " +
                "AND e.semester = :semester");
        query.setParameter("grade", grade);
        query.setParameter("courseCode", courseCode);
        query.setParameter("studentId", studentId);
        query.setParameter("year", year);
        query.setParameter("semester", semester);
        int updatedCount = query.executeUpdate();
        entityManager.getTransaction().commit();

        if (updatedCount > 0) {
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("No matching enrollment found.");
        }

    }

    public static Double gradeToScore(String studentId, Integer totalCredit) {
        String query = "SELECT e FROM Enrollment e WHERE e.student.studentId = :studentId";
        List<Enrollment> enrollments = entityManager.createQuery(query, Enrollment.class)
                .setParameter("studentId", studentId)
                .getResultList();
        String grade = enrollments.get(0).getGrade();
        Double score;
        if (grade.equals("A")) {
            score = 4.0 * totalCredit;
        } else if (grade.equals("AB")) {
            score = 3.5 * totalCredit;
        } else if (grade.equals("B")) {
            score = 3.0 * totalCredit;
        } else if (grade.equals("BC")) {
            score = 2.5 * totalCredit;
        } else if (grade.equals("C")) {
            score = 2.0 * totalCredit;
        } else if (grade.equals("D")) {
            score = 1.0 * totalCredit;
        } else {
            score = 0.0;
        }
        return score;
    }

    public static void ShowStudentDetails(String studentId) {
        Integer totalCredit = 0;
        String query = "SELECT e FROM Enrollment e WHERE e.student.studentId = :studentId";
        List<Enrollment> enrollments = entityManager.createQuery(query, Enrollment.class)
                .setParameter("studentId", studentId)
                .getResultList();

        for (Enrollment e : enrollments) {
            totalCredit = e.getCourse().getCredit();
            e.getStudent().setGpa(gradeToScore(studentId, totalCredit));
          System.out.println(e.getStudent().toString());
        }
 
    }

}
