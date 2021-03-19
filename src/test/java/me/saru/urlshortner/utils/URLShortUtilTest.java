package me.saru.urlshortner.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class URLShortUtilTest {

    @Test
    void encode() {
        String encode = URLShortUtil.encode(100000L);
        assertThat(encode).isEqualTo("cByc");
    }

    @Test
    void decode() {
        long decode = URLShortUtil.decode("cByc");
        assertThat(decode).isEqualTo(100000L);
    }
}