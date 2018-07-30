package com.example;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Course;
import com.example.protobuf.CourseProto.Courses;
import com.example.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

}

@Slf4j
@RestController
class CourseController {

    @Autowired
    public transient CourseRepository repository;

    @GetMapping(path = "/courses")
    public Map<Integer, Course> getCourses() {
        return this.repository.getCourses();
    }

    @GetMapping(path = "/courses/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return this.repository.getCourse(id);
    }

    @GetMapping(path = "/test/courses/{totalElements}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Course>> getCourses(@PathVariable int totalElements) {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start("get");

        Collection<Course> courses = this.repository.courses(totalElements);

        stopWatch.stop();
        log.info("Total time in milliseconds get: {}", stopWatch.getLastTaskTimeMillis());
        return ResponseEntity.ok(courses);

    }

    @GetMapping(path = "test/proto/courses/{totalElements}")
    public ResponseEntity<Courses> getProtoCourses(@PathVariable int totalElements) {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start("getProto");

        Courses courses = this.repository.protobufCourses(totalElements);

        stopWatch.stop();
        log.info("Total time in milliseconds getProto: {}", stopWatch.getLastTaskTimeMillis());
        return ResponseEntity.ok(courses);

    }

}
