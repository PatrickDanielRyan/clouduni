/*
 * StudentRepository.java
 *
 * HTTP <--> Controller <--> Service <--> Repository <--> Database
 *
 * The Respository saves, retrieves, and deletes data by communicating with the database.
 */

package com.example.clouduni.repository;

import com.example.clouduni.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
