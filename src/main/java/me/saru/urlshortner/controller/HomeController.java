package me.saru.urlshortner.controller;

import lombok.RequiredArgsConstructor;
import me.saru.urlshortner.service.ShortUrlService;
import me.saru.urlshortner.utils.URLShortUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ShortUrlService shortUrlService;

    @GetMapping("/{path}")
    public String redirect(@PathVariable String path) {
        Long decode = URLShortUtil.decode(path);
        String targetUrl = shortUrlService.findById(decode);
        return "redirect:" + targetUrl;
    }

    @GetMapping("/not-found")
    public String notFound() {
        return "not-found";
    }
}
