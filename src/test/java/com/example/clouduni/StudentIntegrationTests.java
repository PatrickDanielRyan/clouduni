/*
 * StudentIntegrationTests.java
 *
 * Integration tests for requests and responses related to the Student.
 */

package com.example.clouduni;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class StudentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // Test: Add student to lecturer.
    @Test
    void shouldAddStudentToLecturer() throws Exception {

        String lecturerJson = """
        {
          "name": "John",
          "surname": "Doe"
        }
        """;

        mockMvc.perform(post("/lecturers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(lecturerJson))
                .andExpect(status().isOk());

        String studentJson = """
        {
          "name": "Alice",
          "surname": "Smith"
        }
        """;

        mockMvc.perform(post("/students/add/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.surname").value("Smith"));
    }

    // Test: Get student by Id.
    @Test
    void shouldGetStudentById() throws Exception {

        String lecturerJson = """
        {
          "name": "John",
          "surname": "Doe"
        }
        """;

        mockMvc.perform(post("/lecturers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(lecturerJson))
                .andExpect(status().isOk());

        String studentJson = """
        {
          "name": "Alice",
          "surname": "Smith"
        }
        """;

        mockMvc.perform(post("/students/add/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.surname").value("Smith"))
                .andExpect(jsonPath("$.lecturers").isArray())
                .andExpect(jsonPath("$.lecturers[0].name").value("John"))
                .andExpect(jsonPath("$.lecturers[0].surname").value("Doe"));
    }

    // Test: Invalid student name.
    @Test
    void shouldFailWhenStudentNameInvalid() throws Exception {

        String json = """
        {
          "name": "Alice@",
          "surname": "Smith"
        }
        """;

        mockMvc.perform(post("/students/add/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").exists());
    }

    // Test: Invalid student surname.
    @Test
    void shouldFailWhenStudentSurnameInvalid() throws Exception {

        String json = """
        {
          "name": "Alice",
          "surname": "Smith!"
        }
        """;

        mockMvc.perform(post("/students/add/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.surname").exists());
    }

    // Test: Empty student name.
    @Test
    void shouldFailWhenStudentNameEmpty() throws Exception {

        String json = """
        {
          "name": "",
          "surname": "Smith"
        }
        """;

        mockMvc.perform(post("/students/add/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").exists());
    }

    // Test: Empty student surname.
    @Test
    void shouldFailWhenStudentSurnameEmpty() throws Exception {

        String json = """
        {
          "name": "Alice",
          "surname": ""
        }
        """;

        mockMvc.perform(post("/students/add/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.surname").exists());
    }

    // Test: Lecturer not found.
    @Test
    void shouldFailWhenLecturerNotFound() throws Exception {

        String json = """
        {
          "name": "Alice",
          "surname": "Smith"
        }
        """;

        mockMvc.perform(post("/students/add/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
}
