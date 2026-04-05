/**
 * LecturerService.java
 *
 * HTTP <--> Controller <--> Service <--> Repository <--> Database
 *
 * The Service implements business logic.
 */

package com.example.clouduni.service;

import com.example.clouduni.model.Lecturer;
import com.example.clouduni.repository.LecturerRepository;
import com.example.clouduni.dto.LecturerDto;
import com.example.clouduni.dto.LecturerResponseDto;
import com.example.clouduni.dto.StudentSimpleDto;

import org.springframework.stereotype.Service;

@Service
public class LecturerService {

  private final LecturerRepository lecturerRepository;

  public LecturerService(LecturerRepository lecturerRepository) {
    this.lecturerRepository = lecturerRepository;
  }

  public LecturerResponseDto create(LecturerDto lecturerDto) {
    Lecturer lecturer = new Lecturer();
    lecturer.setName(lecturerDto.getName());
    lecturer.setSurname(lecturerDto.getSurname());
    return toResponseDto(lecturerRepository.save(lecturer));
  }

  public LecturerResponseDto get(Long id) {
    Lecturer lecturer = lecturerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Lecturer::get(): Lecturer with id=" + id + "not found"));
    return toResponseDto(lecturer);
  }

  public LecturerResponseDto toResponseDto(Lecturer lecturer) {
    LecturerResponseDto lecturerResponseDto = new LecturerResponseDto();
    lecturerResponseDto.id = lecturer.getId();
    lecturerResponseDto.name = lecturer.getName();
    lecturerResponseDto.surname = lecturer.getSurname();

    lecturerResponseDto.students = lecturer.getStudents().stream().map(s -> {
      StudentSimpleDto studentsSimpleDto = new StudentSimpleDto();
      studentsSimpleDto.id = s.getId();
      studentsSimpleDto.name = s.getName();
      studentsSimpleDto.surname = s.getSurname();
      return studentsSimpleDto;
    }).toList();

    return lecturerResponseDto;
  }
}