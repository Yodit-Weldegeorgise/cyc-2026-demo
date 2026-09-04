package com.learningcenter.demo.mistake1;

import com.learningcenter.demo.JavaApiMistakesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = JavaApiMistakesApplication.class)
@AutoConfigureMockMvc
class ApiDesignDemoTest {
    @Autowired MockMvc mvc;

    @Test void reviewsEndpointReturnsPluralResourceName() throws Exception {
        mvc.perform(get("/demo/good/reviews"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].review").exists());
    }

    @Test void creditBalanceEndpointUsesKebabCase() throws Exception {
        mvc.perform(get("/demo/good/parents/1/credit-balance"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber());
    }
}

