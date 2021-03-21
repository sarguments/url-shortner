package me.saru.urlshortner.data;

import lombok.*;

public class ShortUrlDto {

    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Req {
        private String url;
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class Res {
        private String url;
        private Long count;
    }

    private ShortUrlDto() {
        // empty
    }
}
