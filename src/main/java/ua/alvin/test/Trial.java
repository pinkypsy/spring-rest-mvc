package ua.alvin.test;

import ua.alvin.entity.Student;
import ua.alvin.exception.OutOfBoundsExceptionToJson;

public class Trial {
    public static void main(String[] args) {
        Student student = new Student("cc", "catch");

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student);
    }
}