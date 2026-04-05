/*
 * LecturerRepository.java
 *
 * HTTP <--> Controller <--> Service <--> Repository <--> Database
 *
 * The Respository accesses data by communicating with the database.
 */

package com.example.clouduni.repository;

import com.example.clouduni.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {}
