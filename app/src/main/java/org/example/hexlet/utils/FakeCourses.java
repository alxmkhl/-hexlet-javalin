package org.example.hexlet.utils;

import com.github.javafaker.Faker;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;

public class FakeCourses {
    public static List<Course> getCourseList(){
        Faker faker = new Faker();
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Course course = new Course(String.valueOf(i), faker.company().name(), faker.company().industry());
            courseList.add(course);
        }
        return courseList;
    }
}
