package com.example.di;

public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public void displayCourse() {
        System.out.println("Enrolled in course: " + name);
    }
}
