/*
 * LecturerIntegrationTests.java
 *
 * Integration tests for requests and responses related to the Lecturer.
 */

package com.example.clouduni;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class LecturerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // Test: Create and get lecturere with valid name.
    @Test
    void shouldCreateAndFetchLecturer() throws Exception {
        String json = """
        {
          "name": "John",
          "surname": "Doe"
        }
        """;

        mockMvc.perform(post("/lecturers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());

        mockMvc.perform(get("/lecturers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Doe"));
    }

    // Test: Get lecturer that doesn't exist.
    @Test
    void shouldReturnErrorWhenLecturerNotFound() throws Exception {
        mockMvc.perform(get("/lecturers/999"))
                .andExpect(status().isBadRequest());
    }

    // Test: Create lecturer with empty name.
    @Test
    void shouldFailWhenNameIsEmpty() throws Exception {
        String json = """
        {
          "name": "",
          "surname": "Doe"
        }
        """;

        mockMvc.perform(post("/lecturers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").exists());
    }

    // Test: Create lecturer with empty surname.
    @Test
    void shouldFailWhenSurnameIsEmpty() throws Exception {
        String json = """
        {
          "name": "John",
          "surname": ""
        }
        """;

        mockMvc.perform(post("/lecturers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.surname").exists());
    }

    // Test: Create lecturer with name that has invalid characters.
    @Test
    void shouldFailWhenNameHasInvalidCharacters() throws Exception {
        String json = """
        {
          "name": "John@",
          "surname": "Doe"
        }
        """;

        mockMvc.perform(post("/lecturers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").exists());
    }

    // Test: Create lecturer with surname that has invalid characters.
    @Test
    void shouldFailWhenSurnameHasInvalidCharacters() throws Exception {
        String json = """
        {
          "name": "John",
          "surname": "Doe!"
        }
        """;

        mockMvc.perform(post("/lecturers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.surname").exists());
    }

    // Test: Get list of students assigned to lecturer.
    @Test
    void shouldReturnLecturerWithStudents() throws Exception {
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

        mockMvc.perform(get("/lecturers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.students").isArray())
                .andExpect(jsonPath("$.students[0].name").value("Alice"))
                .andExpect(jsonPath("$.students[0].surname").value("Smith"));
    }

}