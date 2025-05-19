package com.example.microservice.service;

import com.example.microservice.dto.CourseResponseDTO;
import com.example.microservice.models.Course;
import com.example.microservice.models.Grade;
import com.example.microservice.repository.CourseRepository;
import com.example.microservice.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradeRepository gradeRepository;


    public ResponseEntity<?> getCourseById(long id){
        Optional<Course> course = courseRepository.findById(id);

        if(course.isPresent()){
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public ResponseEntity<?> getGradeByCourseId(long id){
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if(optionalCourse.isPresent()){
            Course course = optionalCourse.get();
            List<Grade> grades = gradeRepository.findByCourseId(id);

            CourseResponseDTO response = new CourseResponseDTO(
                    course.getId(),
                    course.getName(),
                    grades
            );
            return ResponseEntity.ok(response);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
