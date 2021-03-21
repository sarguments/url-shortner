package me.saru.urlshortner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefaultSpringTest<T> {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected String convertToJson(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T convertToJson(MvcResult result, Class<T> clazz) throws IOException {
        return objectMapper.readValue(result.getResponse().getContentAsString(), clazz);
    }
}