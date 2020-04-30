package com.example.ELearning;

import com.example.ELearning.model.Course;
import com.example.ELearning.model.User;
import com.example.ELearning.repository.CourseRepository;
import com.example.ELearning.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ELearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearningApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository, UserRepository userRepository) {
		return args -> {
			courseRepository.save(new Course("1", "Java Basics", "Java ", 10));
			User user = new User("1", "Madhumitha", "smadhu", "smadhu", 10);
			user.setCourses(new ArrayList<>(Arrays.asList(new Course("1", "Java Basics", "Java ", 10))));
			userRepository.save(user);
		};
	}
}
