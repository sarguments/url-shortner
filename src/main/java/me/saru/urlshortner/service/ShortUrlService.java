package me.saru.urlshortner.service;

import lombok.RequiredArgsConstructor;
import me.saru.urlshortner.config.ConfigProperty;
import me.saru.urlshortner.domain.ShortUrl;
import me.saru.urlshortner.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ConfigProperty configProperty;
    private final ShortUrlRepository shortUrlRepository;

    /**
     * 원본 URL이 이미 요청된적이 있는 경우엔 카운트 값을 1 증가시키고 저장된 id값을 Base41로 변환한다.
     * 새로운 요청인 경우 저장 후 얻어진 id 값을 Base41로 변환한다.
     */
    @Transactional
    public ShortUrl findByOriginalUrl(String url) {
        Optional<ShortUrl> urlOptional = shortUrlRepository.findByUrl(url);
        ShortUrl shortUrl = urlOptional.orElseGet(() -> shortUrlRepository.save(new ShortUrl(url)));
        shortUrl.increaseCount();
        return shortUrl;
    }

    /**
     * db에 존재하지 않는 단축 url 을 요청한 경우 not-found 를 리턴한다.
     * 그 외엔 해당 단축 url의 원본 url을 리턴한다.
     */
    @Transactional(readOnly = true)
    public String findById(Long decode) {
        ShortUrl shortUrl = shortUrlRepository.findById(decode).orElse(new ShortUrl(configProperty.getBaseUrl() + "not-found"));
        return shortUrl.getUrl();
    }
}
