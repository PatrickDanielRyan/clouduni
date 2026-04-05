/*
 * LecturerResponseDto.java
 *
 * DTO for LecturerResponse.
 * Needed to break circular dependencies between Lecturers and Students.
 */

package com.example.clouduni.dto;

import java.util.List;

public class LecturerResponseDto {
  public Long id;
  public String name;
  public String surname;
  public List<StudentSimpleDto> students;
}
