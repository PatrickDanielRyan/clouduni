/*
 * StudentResponseDto.java
 *
 * DTO for StudentResponse.
 * Needed to break circular dependencies between Lecturers and Students.
 */

package com.example.clouduni.dto;

import java.util.List;

public class StudentResponseDto {
  public Long id;
  public String name;
  public String surname;
  public List<LecturerSimpleDto> lecturers;
}
