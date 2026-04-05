/**
 * StudentController.java
 *
 * HTTP <--> Controller <--> Service <--> Repository <--> Database
 *
 * The Controller receives HTTP requests, validates inputs,
 * calls the service, and returns an HTTP response.
 */

package com.example.clouduni.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import com.example.clouduni.service.StudentService;
import com.example.clouduni.dto.StudentDto;
import com.example.clouduni.dto.StudentResponseDto;

@RestController
class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/students/add/{lecturerId}")
  public ResponseEntity<StudentResponseDto> add(@PathVariable Long lecturerId,
      @RequestBody @Valid StudentDto studentDto) {
    return ResponseEntity.ok(studentService.add(lecturerId, studentDto));
  }

  @GetMapping("/students/{studentId}")
  public ResponseEntity<StudentResponseDto> get(@PathVariable Long studentId) {
    return ResponseEntity.ok(studentService.get(studentId));
  }
}