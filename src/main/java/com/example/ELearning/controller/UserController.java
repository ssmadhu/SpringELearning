package com.example.ELearning.controller;

import com.example.ELearning.model.Course;
import com.example.ELearning.model.User;
import com.example.ELearning.service.CourseService;
import com.example.ELearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method= RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println("Get method");
        return this.userService.getUsers();
    }

    @RequestMapping(method= RequestMethod.GET, value= "/{id}")
    public User getCourses(@PathVariable String id) {
        return this.userService.getUser(id);
    }
////
////    @RequestMapping(method= RequestMethod.POST)
////    public void addCourse(@RequestBody Course course) {
////        this.courseService.addCourse(course);
////    }
////
////    @RequestMapping(method= RequestMethod.PUT, value= "/{id}")
////    public void addCourse(@RequestBody Course course, @PathVariable String id) {
////        this.courseService.updateCourse(id, course);
////    }

//    @RequestMapping(method= RequestMethod.DELETE, value= "/{id}")
//    public void deleteCourse(@PathVariable String id) {
//        this.courseService.deleteCourse(id);
//    }

}
