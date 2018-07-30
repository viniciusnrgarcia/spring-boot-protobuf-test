/**
 * 
 */
package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.example.domain.Course;
import com.example.domain.Student;
import com.example.protobuf.CourseProto;
import com.example.protobuf.CourseProto.Courses;
import com.example.protobuf.CourseProto.Student.PhoneType;

/**
 * @author vinicius-garcia
 *
 */
@Component
public class CourseRepository {

    public Map<Integer, Course> getCourses() {
        Map<Integer, Course> courses = new HashMap<>();

        Course course = Course.builder().id(1).courseName("REST with Spring")
                .student(Collections.unmodifiableList(Arrays.asList(Student.builder().email("s1@email.com")
                        .firstName("Vinicius").lastName("Garcia").id(1).build())))
                .build();
        courses.put(course.getId(), course);

        Course course2 = Course.builder().id(2).courseName("Spring Security")
                .student(Collections.unmodifiableList(Arrays.asList(Student.builder().email("s1@email.com")
                        .firstName("Vinicius").lastName("Garcia").id(2).build())))
                .build();

        courses.put(course.getId(), course);
        courses.put(course2.getId(), course2);

        return courses;

    }

    public Course getCourse(final int key) {
        return this.getCourses().get(key);
    }

    public Collection<Course> courses(final int totalElements) {

        Collection<Course> courses = new ArrayList<>(totalElements);

        IntStream.range(0, totalElements).forEach(iteration -> {
            Course course = Course.builder().id(1).courseName("REST with Spring")
                    .student(Collections.unmodifiableList(Arrays.asList(Student.builder().email("s1@email.com")
                            .firstName("Vinicius").lastName("Garcia").id(1).build())))
                    .build();

            courses.add(course);
        });

        return courses;

    }

    public Courses protobufCourses(final int totalElements) {
        com.example.protobuf.CourseProto.Courses.Builder courses = CourseProto.Courses.newBuilder();

        IntStream.range(0, totalElements).forEach(iteration -> {

            final CourseProto.Course c = CourseProto.Course
                    .newBuilder().setCourseName("REST with Spring").setId(
                            1)
                    .addStudent(com.example.protobuf.CourseProto.Student.newBuilder().setEmail("email")
                            .setFirstName("Vinicius").setLastName("Garcia")
                            .addPhone(com.example.protobuf.CourseProto.Student.PhoneNumber.newBuilder()
                                    .setNumber("123456").setType(PhoneType.MOBILE).build())
                            .build())
                    .build();

            courses.addCourses(c);
        });

        return courses.build();

    }

}
