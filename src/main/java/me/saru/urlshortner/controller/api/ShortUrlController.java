package me.saru.urlshortner.controller.api;

import me.saru.urlshortner.domain.ShortUrl;
import me.saru.urlshortner.exception.NotFoundException;
import me.saru.urlshortner.utils.ApiUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shorturl")
public class ShortUrlController {

    @GetMapping("")
    public ApiUtils.ApiResult<ShortUrl> error() {
        throw new NotFoundException("test");
    }
}
