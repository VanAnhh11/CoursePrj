/*
 * @ (#) Course.java    1.0     8/25/2024
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
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course() {
        this.id = "";
        this.title = "";
        this.credit = 0;
        this.department = "";
    }

    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    public String toString() {
        return String.format("%-10%-30%5d%5s%-15s", id, title, credit, department);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
