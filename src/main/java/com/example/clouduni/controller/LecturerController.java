/**
 * LecturerController.java
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

import com.example.clouduni.service.LecturerService;
import com.example.clouduni.dto.LecturerDto;
import com.example.clouduni.dto.LecturerResponseDto;

@RestController
class LecturerController {

  private final LecturerService lecturerService;

  public LecturerController(LecturerService lecturerService) {
    this.lecturerService = lecturerService;
  }

  @PostMapping("/lecturers")
  public ResponseEntity<LecturerResponseDto> create(@RequestBody @Valid LecturerDto lecturerDto) {
    return ResponseEntity.ok(lecturerService.create(lecturerDto));
  }

  @GetMapping("/lecturers/{lecturerId}")
  public ResponseEntity<LecturerResponseDto> get(@PathVariable Long lecturerId) {
    return ResponseEntity.ok(lecturerService.get(lecturerId));
  }
}