/*
 * @ (#) TestCourse.java    1.0     8/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.fit.se;

/*
 * @description
 * @author : Anh Van Duong
 * @Date : 8/25/2024
 * @version :  1.0
 */

import java.util.Scanner;
import java.util.List;

public class TestCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList courselist = new CourseList(10);

        initData(courselist);

        int choice;

        do {
            switch (choice) {
                case 1:
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (CourseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }

                case 2:
                    System.out.println("Course List : ");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : CourseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;
                case 3:
                    System.out.print("Nhap ma khoa hoc can xoa: ");
                    String removeId = sc.nextLine();
                    CourseList.removeCourse(removeId);
                    break;
                case 4:
                    System.out.print("Nhap ma khoa hoc can tim: ");
                    String CourseId = sc.nextLine();
                    Course findCourse = (Course) CourseList.SreachCourseById(CourseId);
                    if (findCourse != null) {
                        System.out.println("Khoa hoc: " + findCourse);
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 5:
                    System.out.print("Nhap ten khoa hoc can tim: ");
                    String Title = sc.nextLine();
                    List<Course> foundCoursesByTitle = CourseList.SreachCoursesByTitle(Title);
                    if (foundCoursesByTitle != null) {
                        System.out.println(foundCoursesByTitle);
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 6:
                    System.out.print("Nhap khoa phu trach can tim: ");
                    String Department = sc.nextLine();
                    List<Course> foundCoursesByDepartment = CourseList.SreachCourseByDepartment(Department);
                    if (foundCoursesByDepartment != null) {
                        System.out.println(foundCoursesByDepartment);
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 7:
                    List<Course> sortedCourses = CourseList.SortCourse();
                    System.out.println(sortedCourses);
                    break;
                case 8:
                    List<Course> maxCreditCourses = CourseList.findMaxCreditCourses();
                    System.out.println(maxCreditCourses);
                    break;
                case 9:
                    String departmentWithMostCourses = CourseList.findDepartmentWithMostCourses();
                    System.out.println("Khoa co nhieu khoa hoc nhat: " + departmentWithMostCourses);
                    break;
                case 10:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
        while (choice != 0);
    }
        public static void initData(CourseList courselist){
          if (courselist.isEmpty()) {
              System.out.println("Danh sach trong");
              } else {
              System.out.printf("%-10s%-20s%-10s%-20s%n", "ID", "Title", "Credit", "Department");

              for (Course course : courselist) {
                  System.out.printf("%-10s %-20s %-10d %-20s%n", course.getId(), course.getTitle(), course.getCredit(), course.getDepartment());
              }
          }
        }
          }


