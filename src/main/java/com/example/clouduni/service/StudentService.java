/**
 * StudentService.java
 *
 * HTTP <--> Controller <--> Service <--> Repository <--> Database
 *
 * The Service implements business logic.
 */

package com.example.clouduni.service;

import com.example.clouduni.model.Lecturer;
import com.example.clouduni.model.Student;
import com.example.clouduni.repository.LecturerRepository;
import com.example.clouduni.repository.StudentRepository;
import com.example.clouduni.dto.StudentDto;
import com.example.clouduni.dto.StudentResponseDto;
import com.example.clouduni.dto.LecturerSimpleDto;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;
  private final LecturerRepository lecturerRepository;

  public StudentService(StudentRepository studentRepository, LecturerRepository lecturerRepository) {
    this.studentRepository = studentRepository;
    this.lecturerRepository = lecturerRepository;
  }

  public StudentResponseDto add(Long lecturerId, StudentDto studentDto) {

    Lecturer lecturer = lecturerRepository.findById(lecturerId)
        .orElseThrow(() -> new RuntimeException("Student::add(): Lecturer with id=" + lecturerId + " not found"));

    Student student = new Student();
    student.setName(studentDto.getName());
    student.setSurname(studentDto.getSurname());
    student = studentRepository.save(student);

    // Only update owning side to avoid recursion issues
    lecturer.getStudents().add(student);
    // student.getLecturers().add(lecturer);
    lecturerRepository.save(lecturer);

    return toResponseDto(student);
  }

  public StudentResponseDto get(Long id) {
    Student student = studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student::get(): Student with id=" + id + "not found"));

    return toResponseDto(student);
  }

  public StudentResponseDto toResponseDto(Student student) {
    StudentResponseDto studentResponseDto = new StudentResponseDto();
    studentResponseDto.id = student.getId();
    studentResponseDto.name = student.getName();
    studentResponseDto.surname = student.getSurname();

    studentResponseDto.lecturers = student.getLecturers().stream().map(l -> {
      LecturerSimpleDto lecturerSimpleDto = new LecturerSimpleDto();
      lecturerSimpleDto.id = l.getId();
      lecturerSimpleDto.name = l.getName();
      lecturerSimpleDto.surname = l.getSurname();
      return lecturerSimpleDto;
    }).toList();

    return studentResponseDto;
  }
}