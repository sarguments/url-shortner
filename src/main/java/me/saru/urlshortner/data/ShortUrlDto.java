package me.saru.urlshortner.data;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ShortUrlDto {

    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Req {
        @NotEmpty(message = "Url must be not empty")
        @Size(max = 1000, message = "Url length must be under 1000")
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
