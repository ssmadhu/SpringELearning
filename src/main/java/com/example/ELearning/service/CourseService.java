package com.example.ELearning.service;

import com.example.ELearning.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("1", "Java Basics", "Java Core concepts", 10),
            new Course("2", "Java J2EE", "Java J2EE concepts", 15),
            new Course("3", "Spring", "Spring Boot concepts", 25)
    ));
    public List<Course> getCourses(){
        return courses;
    }

    public Course getCourse(String id) {
        return this.courses.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void updateCourse(String id, Course course) {
        Course matchedCourse = this.getCourse(id);
        matchedCourse.setName(course.getName());
        matchedCourse.setDescription(course.getDescription());
        matchedCourse.setDuration(course.getDuration());
    }

    public void deleteCourse(String id) {
        this.courses.remove(this.getCourse(id));
    }
}
