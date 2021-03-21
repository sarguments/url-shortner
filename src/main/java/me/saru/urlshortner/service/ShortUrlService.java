package me.saru.urlshortner.service;

import lombok.RequiredArgsConstructor;
import me.saru.urlshortner.domain.ShortUrl;
import me.saru.urlshortner.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Transactional
    public ShortUrl findByOriginalUrl(String url) {
        Optional<ShortUrl> urlOptional = shortUrlRepository.findByUrl(url);
        ShortUrl shortUrl = urlOptional.orElseGet(() -> shortUrlRepository.save(new ShortUrl(url)));
        shortUrl.increaseCount();
        return shortUrl;
    }
}
