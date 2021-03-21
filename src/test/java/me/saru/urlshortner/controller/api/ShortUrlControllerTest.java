package me.saru.urlshortner.controller.api;

import me.saru.urlshortner.DefaultSpringTest;
import me.saru.urlshortner.data.ShortUrlDto;
import me.saru.urlshortner.domain.ShortUrl;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShortUrlControllerTest extends DefaultSpringTest<ShortUrl> {

    @Test
    void checkUrlByHibernateValidator() throws Exception {
        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ShortUrlDto.Req("test")))
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success", is(false)));

        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ShortUrlDto.Req("test.com")))
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success", is(false)));

        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ShortUrlDto.Req("http://test.com")))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response.url", is("http://localhost:8080/cByc")));

        mockMvc.perform(get("/cByc"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void generateShortUrlTooLong() throws Exception {
        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new ShortUrlDto.Req(String.join("", Collections.nCopies(100, "https://test.com/asdf")))
                        )
                )
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.response").isEmpty())
                .andExpect(jsonPath("$.error.message", is("Url length must be under 1000")));
    }

    @Test
    void generateShortUrlEmpty() throws Exception {
        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ShortUrlDto.Req("")))
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.response").isEmpty())
                .andExpect(jsonPath("$.error.message", is("Url must be not empty")));
    }

    @Test
    void generateShortUrlCount() throws Exception {
        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ShortUrlDto.Req("http://test.com")))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response.count", is(1)));

        mockMvc.perform(post("/api/shorturl")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ShortUrlDto.Req("http://test.com")))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response.count", is(2)));
    }
}