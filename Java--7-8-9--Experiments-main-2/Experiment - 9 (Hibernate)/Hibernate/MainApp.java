package com.example.hibernatecrud;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student s1 = new Student();
        s1.setName("Arya Stark");
        s1.setCourse("Hibernate ORM");
        s1.setEmail("arya@winterfell.com");
        dao.saveStudent(s1);

        System.out.println("All Students:");
        List<Student> list = dao.getAllStudents();
        list.forEach(System.out::println);

        dao.updateStudent(1, "Spring + Hibernate");
        dao.deleteStudent(2);
    }
}
