package com.learningcenter.demo.mistake2;

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
class ValidationDemoTest {
    @Autowired MockMvc mvc;

    @Test void invalidRequestReturnsFieldSpecificMessages() throws Exception {
        mvc.perform(post("/demo/good/validation/children/1/goals")
                .contentType(MediaType.APPLICATION_JSON).content("{\"subjectId\":null,\"title\":\"\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("VALIDATION_FAILED"))
                .andExpect(jsonPath("$.fieldErrors.subjectId").value("Subject ID is required"))
                .andExpect(jsonPath("$.fieldErrors.title").value("Goal title is required"));
    }
}
