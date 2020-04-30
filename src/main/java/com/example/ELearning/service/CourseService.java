package com.example.ELearning.service;

import com.example.ELearning.model.Course;
import com.example.ELearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getCourses(){
       return this.courseRepository.findAll();
    }

    public Course getCourse(String id) {
        return this.courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        this.courseRepository.save(course);
    }

    public void updateCourse(String id, Course course) {
        this.courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        this.courseRepository.deleteById(id);
    }
}
