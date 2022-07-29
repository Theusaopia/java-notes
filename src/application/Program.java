package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * In an online courses portal, each user has a unique code, represented by an integer number.
 *
 * Each instructor of the portal can have many courses, and a same student can enroll in many courses. Thus, the
 * total number of an instructor students isn't simply the sum of all the students of his courses, because there
 * aren't repeated students in more than one course.
 *
 * Alex have 3 courses, A, B and C and wants to know his total number of students.
 *
 * The program must read the students of courses A, B and C of Alex and after that, show the
 * total number of alex students.
 * **/

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();

        populateSet(courseA, "course A", sc);
        populateSet(courseB, "course B", sc);
        populateSet(courseC, "course C", sc);

        Set<Integer> total = new HashSet<>();
        total.addAll(courseA);
        total.addAll(courseB);
        total.addAll(courseC);

        System.out.println("Total students: " + total.size());

        sc.close();
    }

    public static void populateSet(Set<Integer> set, String courseName, Scanner sc) {
        System.out.println("How many students for " + courseName + "?");
        int numberOfStudents = sc.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            set.add(sc.nextInt());
        }
    }
}
