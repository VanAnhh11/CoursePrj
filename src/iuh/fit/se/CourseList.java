/*
 * @ (#) CourseList.java    1.0     8/27/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.fit.se;
/*
 * @description
 * @author : Duong Van Anh
 * @Date : 8/27/2024
 * @version :  1.0
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseList {
    private static List<Course> courses;
    private static int count = 0;

    public CourseList() {
        courses = new ArrayList<>();
    }

    public CourseList(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new ArrayList<>(n);
    }

    public static List<Course> SortCourse() {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getTitle))
                .collect(Collectors.toList());
    }

    public static List<Course> SreachCourseByDepartment(String department) {
        List<Course> result = courses.stream()
                .filter(course -> course.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
        return result.isEmpty() ? null : result;
    }

    public static boolean addCourse(Course course) {
        if (course == null)
            return false;
        if (exists(course))
            return false;
        if (count == courses.size())
            return false;
        courses.add(course);
        count++;
        return true;
    }
    private static boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses.get(i) != null && courses.get(i).getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }

    public static List<Course> getCourses() {
        return new ArrayList<>(courses);
    }


    public static void removeCourse(String courseId) {
        boolean removed = courses.removeIf(course -> course.getId().equals(courseId));
        if (!removed) {
            System.out.println("Error: Course ID not found.");
        }
    }


    public static List<Course> SreachCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return courses;
            }
        }
        return null;
    }

    public static List<Course> SreachCoursesByTitle(String title) {
        List<Course> result = courses.stream()
                .filter(course -> course.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
        return result.isEmpty() ? null : result;
    }


    public static List<Course> findMaxCreditCourses() {
        int maxCredits = courses.stream()
                .mapToInt(Course::getCredit)
                .max()
                .orElse(0);
        return courses.stream()
                .filter(course -> course.getCredit() == maxCredits)
                .collect(Collectors.toList());
    }


    public static String findDepartmentWithMostCourses() {
        return courses.stream()
                .collect(Collectors.groupingBy(Course::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(e -> e.getValue()))
                .map(e -> e.getKey())
                .orElse(null);
    }

    @Override
    public String toString() {
        return "CourseList" + "courses=" + courses;
    }
}
