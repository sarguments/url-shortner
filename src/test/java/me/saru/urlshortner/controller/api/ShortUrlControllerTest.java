package me.saru.urlshortner.controller.api;

import me.saru.urlshortner.DefaultSpringTest;
import me.saru.urlshortner.domain.ShortUrl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShortUrlControllerTest extends DefaultSpringTest<ShortUrl> {
    @Test
    void error() throws Exception {
        mockMvc.perform(get("/api/shorturl"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.error.message", is("test")));
    }
}