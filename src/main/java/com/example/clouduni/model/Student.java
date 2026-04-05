/*
 * Student.java
 *
 * Define the Student entity.
 */

package com.example.clouduni.model;

import java.util.HashSet;
import java.util.Set;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String surname;

  @ManyToMany(mappedBy = "students")
  private Set<Lecturer> lecturers = new HashSet<Lecturer>();

  public Student() {}

  public Student(String name, String surname, Set<Lecturer> lecturers) {
    this.name = name;
    this.surname = surname;
    this.lecturers = lecturers;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public Set<Lecturer> getLecturers() {
    return this.lecturers;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setLecturers(Set<Lecturer> lecturers) {
    this.lecturers = lecturers;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Student))
      return false;
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) &&
        Objects.equals(this.name, student.name) &&
        Objects.equals(this.surname, student.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.surname);
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + this.id +
        ", name='" + this.name + '\'' +
        ", surname='" + this.surname + '\'' +
        '}';
  }
}