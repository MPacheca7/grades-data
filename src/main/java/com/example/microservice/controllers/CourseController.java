package com.example.microservice.controllers;

import com.example.microservice.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/grade/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<?> getGradeByCourseId(@PathVariable Long id){
        return courseService.getGradeByCourseId(id);
    }

}
