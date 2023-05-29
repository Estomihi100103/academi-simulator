package com.project;

import javax.persistence.*;
import com.project.model.*;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("course_pu");
        entityManager = factory.createEntityManager();
        drivApp.initializeEntityManager();
        drivApp.cleanTableEnrollment();
        drivApp.cleanTableStudent();
        drivApp.cleanTableCourse();

        String str;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            str = scanner.nextLine();

            if (str.equals("---")) {
                break;
            } else {
                String split[] = str.split("#");

                switch (split[0]) {
                    case "course-add":
                        drivApp.createCourse(split[1], split[2], Integer.parseInt(split[3]), split[4]);
                        break;
                    case "course-show":
                        drivApp.ShowCourse();
                        break;
                    case "student-add":
                        drivApp.CreateStudent(split[1], split[2], split[3], split[4]);
                        break;
                    case "student-show":
                        drivApp.ShowStudent();
                        break;
                    case "enrollment-add":
                        drivApp.createEnrollment(split[1], split[2], split[3], split[4]);
                        break;
                    case "enrollment-show":
                        drivApp.ShowEnrollment();
                        break;
                    case "enrollment-grade":
                        drivApp.setGrade(split[1], split[2], split[3], split[4], split[5]);
                        break;
                    case "student-details":
                        drivApp.ShowStudentDetails(split[1]);
                        break;

                    default:
                        break;
                }
            }
        }
        // Pemanggilan entityManager.close() setelah menjalankan semua perintah
        entityManager.close();
    }

}
