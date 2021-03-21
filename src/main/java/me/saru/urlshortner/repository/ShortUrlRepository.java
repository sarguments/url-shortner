package me.saru.urlshortner.repository;

import me.saru.urlshortner.domain.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByUrl(String url);
}
