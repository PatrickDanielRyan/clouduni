/*
 * Lecturer.java
 *
 * Define the Lecturer entity.
 */

package com.example.clouduni.model;

import java.util.HashSet;
import java.util.Set;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String surname;

  @ManyToMany
  @JoinTable(name = "lecturer_student", joinColumns = @JoinColumn(name = "lecturer_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
  private Set<Student> students = new HashSet<Student>();

  public Lecturer() {}

  public Lecturer(String name, String surname, Set<Student> students) {
    this.name = name;
    this.surname = surname;
    this.students = students;
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

  public Set<Student> getStudents() {
    return this.students;
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

  public void setStudents(Set<Student> students) {
    this.students = students;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Lecturer))
      return false;
    Lecturer lecturer = (Lecturer) o;
    return Objects.equals(this.id, lecturer.id) &&
        Objects.equals(this.name, lecturer.name) &&
        Objects.equals(this.surname, lecturer.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.surname);
  }

  @Override
  public String toString() {
    return "Lecturer{" +
        "id=" + this.id +
        ", name='" + this.name + '\'' +
        ", surname='" + this.surname + '\'' +
        '}';
  }
}