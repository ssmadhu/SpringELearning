package com.example.ELearning.service;

import com.example.ELearning.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getCourses();
    List<Course> getCoursesMatch(String name);
    void addCourse(Course course);
    Course getCourse(String id);
    void updateCourse(String id, Course course);
    void deleteCourse(String id);
}
