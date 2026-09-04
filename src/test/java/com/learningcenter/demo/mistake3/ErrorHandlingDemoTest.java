package com.learningcenter.demo.mistake3;

import com.learningcenter.demo.JavaApiMistakesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = JavaApiMistakesApplication.class)
@AutoConfigureMockMvc
class ErrorHandlingDemoTest {
    @Autowired MockMvc mvc;

    @Test void missingSessionReturnsUseful404() throws Exception {
        mvc.perform(get("/demo/good/sessions/99999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("SESSION_NOT_FOUND"))
                .andExpect(jsonPath("$.message").value("Session with ID 99999 was not found."));
    }

    @Test void unexpectedFailureIsSanitized() throws Exception {
        mvc.perform(get("/demo/good/sessions/demo/unexpected"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value("INTERNAL_SERVER_ERROR"))
                .andExpect(content().string(not(containsString("sensitive detail"))))
                .andExpect(content().string(not(containsString("at com.learningcenter"))));
    }
}
