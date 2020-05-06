package com.example.ELearning.service;

import com.example.ELearning.model.Course;
import com.example.ELearning.model.User;
import com.example.ELearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(String id){
        return this.userRepository.findById(id).get();
    }
    public List<Course> getUsersCourse(String id) {
        return this.userRepository.findById(id).get().getCourses();
    }

    public void addUsersCourse(Course course, String userId) {
        User user = this.userRepository.findById(userId).get();
        List<Course> courses = user.getCourses();
        courses.add(course);
        user.setCourses(courses);
        this.userRepository.save(user);
    }





}
