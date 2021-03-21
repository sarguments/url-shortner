package me.saru.urlshortner.controller;

import me.saru.urlshortner.DefaultSpringTest;
import me.saru.urlshortner.domain.ShortUrl;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HomeControllerTest extends DefaultSpringTest<ShortUrl> {

    @Test
    void redirect() throws Exception {
        mockMvc.perform(get("/asdf"))
                .andExpect(status().is3xxRedirection());
    }
}