package com.example.ELearning.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    String id;
    String name;
    String description;
    int duration;

    @ManyToMany(mappedBy = "userCourses")
    List<User> users = new ArrayList<>();
    public Course() {

    }
    public Course(String id, String name, String description, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
