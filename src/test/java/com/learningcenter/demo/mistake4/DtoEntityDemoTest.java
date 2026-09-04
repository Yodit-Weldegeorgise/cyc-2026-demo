package com.learningcenter.demo.mistake4;

import com.learningcenter.demo.JavaApiMistakesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = JavaApiMistakesApplication.class)
@AutoConfigureMockMvc
class DtoEntityDemoTest {
    @Autowired MockMvc mvc;

    @Test void dtoResponseContainsOnlyPromisedFields() throws Exception {
        mvc.perform(post("/demo/good/dto/children/1/goals").contentType(MediaType.APPLICATION_JSON)
                .content("{\"subjectId\":1,\"title\":\"Improve multiplication skills\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.goalId").isNumber())
                .andExpect(jsonPath("$.childId").value(1))
                .andExpect(jsonPath("$.subjectId").value(1))
                .andExpect(jsonPath("$.subjectName").value("Mathematics"))
                .andExpect(jsonPath("$.title").value("Improve multiplication skills"))
                .andExpect(jsonPath("$.internalNotes").doesNotExist())
                .andExpect(jsonPath("$.child").doesNotExist())
                .andExpect(jsonPath("$.subject").doesNotExist());
    }
}
