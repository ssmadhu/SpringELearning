package com.example.ELearning.controller;

import com.example.ELearning.model.Course;
import com.example.ELearning.model.User;
import com.example.ELearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{id}/courses")
public class UserCourseController {

    @Autowired
    UserService userService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Course> getUsersCourses(@PathVariable String id) {
        return this.userService.getUsersCourse(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    public void addUsersCourse(@PathVariable String id, @RequestBody Course course) {
        this.userService.addUsersCourse(course, id);
    }


}
