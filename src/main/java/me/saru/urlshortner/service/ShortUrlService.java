package me.saru.urlshortner.service;

import lombok.RequiredArgsConstructor;
import me.saru.urlshortner.domain.ShortUrl;
import me.saru.urlshortner.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrl findByOriginalUrl(String url) {
        Optional<ShortUrl> urlOptional = shortUrlRepository.findByUrl(url);
        return urlOptional.orElseGet(() -> shortUrlRepository.save(new ShortUrl(url)));
    }
}
