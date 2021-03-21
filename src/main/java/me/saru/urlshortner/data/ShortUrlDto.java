package me.saru.urlshortner.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

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
        @URL(message = "Url is invalid")
        private String url;
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class Res {
        private String url;
        private Long count;

        public Res(Long count, String encode) {
            this.url = encode;
            this.count = count;
        }
    }

    private ShortUrlDto() {
        // empty
    }
}
