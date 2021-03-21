package me.saru.urlshortner.controller.api;

import lombok.extern.slf4j.Slf4j;
import me.saru.urlshortner.data.ShortUrlDto;
import me.saru.urlshortner.domain.ShortUrl;
import me.saru.urlshortner.exception.NotFoundException;
import me.saru.urlshortner.utils.ApiUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shorturl")
@Slf4j
public class ShortUrlController {

    @GetMapping("")
    public ApiUtils.ApiResult<ShortUrl> error() {
        throw new NotFoundException("test");
    }

    @PostMapping("")
    public ApiUtils.ApiResult<ShortUrl> generateUrl(@RequestBody @Valid ShortUrlDto.Req req) {
        log.debug("req : {}", req);

        return ApiUtils.success(new ShortUrl("test"));
    }
}
