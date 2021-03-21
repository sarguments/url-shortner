package me.saru.urlshortner.controller.api;

import me.saru.urlshortner.DefaultSpringTest;
import me.saru.urlshortner.data.ShortUrlDto;
import me.saru.urlshortner.domain.ShortUrl;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @Test
    void generateShortUrl() throws Exception {
        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ShortUrlDto.Req("test")))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response.url").isNotEmpty());
    }
}