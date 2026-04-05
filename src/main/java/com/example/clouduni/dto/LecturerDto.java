/*
 * LecturerDto.java
 *
 * DTO for Lecturer.  Used to validate the Lecturer fields.
 */

package com.example.clouduni.dto;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class LecturerDto {

  @NotBlank(message = "Name must not be blank")
  @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Name must be alphanumeric")
  private String name;

  @NotBlank(message = "Surname must not be blank")
  @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Surname must be alphanumeric")
  private String surname;

  public LecturerDto() {
  }

  public LecturerDto(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof LecturerDto))
      return false;
    LecturerDto lecturerDto = (LecturerDto) o;
    return Objects.equals(this.name, lecturerDto.name) &&
        Objects.equals(this.surname, lecturerDto.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.surname);
  }

  @Override
  public String toString() {
    return "LecturerDto{" +
        "name='" + this.name + '\'' +
        ", surname='" + this.surname + '\'' +
        '}';
  }
}