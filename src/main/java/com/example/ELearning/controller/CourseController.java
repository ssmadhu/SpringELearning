package com.example.ELearning.controller;

import com.example.ELearning.model.Course;
import com.example.ELearning.service.CourseService;
import com.example.ELearning.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    @RequestMapping(method= RequestMethod.GET, value= "/{id}")
    public Course getCourses(@PathVariable  String id) {
        return this.courseService.getCourse(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    public void addCourse(@RequestBody Course course) {
        this.courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value= "/{id}")
    public void addCourse(@RequestBody Course course, @PathVariable String id) {
        this.courseService.updateCourse(id, course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value= "/{id}")
    public void deleteCourse(@PathVariable String id) {
        this.courseService.deleteCourse(id);
    }







}
