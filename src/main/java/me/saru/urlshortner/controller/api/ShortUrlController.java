package me.saru.urlshortner.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.saru.urlshortner.data.ShortUrlDto;
import me.saru.urlshortner.domain.ShortUrl;
import me.saru.urlshortner.service.ShortUrlService;
import me.saru.urlshortner.utils.ApiUtils;
import me.saru.urlshortner.utils.URLShortUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shorturl")
@RequiredArgsConstructor
@Slf4j
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping("")
    public ApiUtils.ApiResult<ShortUrlDto.Res> generateUrl(@RequestBody @Valid ShortUrlDto.Req req) {
        log.debug("req : {}", req);

        ShortUrl shortUrl = shortUrlService.findByOriginalUrl(req.getUrl());

        return ApiUtils.success(new ShortUrlDto.Res(shortUrl.getCount(), URLShortUtil.encode(shortUrl.getId())));
    }
}
