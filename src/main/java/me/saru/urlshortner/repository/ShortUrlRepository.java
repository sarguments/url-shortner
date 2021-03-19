package me.saru.urlshortner.repository;

import me.saru.urlshortner.domain.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
}
