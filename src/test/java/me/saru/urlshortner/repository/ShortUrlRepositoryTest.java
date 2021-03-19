package me.saru.urlshortner.repository;

import me.saru.urlshortner.domain.ShortUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ShortUrlRepositoryTest {
    @Autowired
    TestEntityManager em;

    @Autowired
    ShortUrlRepository shortUrlRepository;

    @Test
    void init() {
        ShortUrl entity1 = shortUrlRepository.save(new ShortUrl("asdf1"));
        em.flush();
        em.clear();

        System.out.println(entity1);

        ShortUrl entity2 = shortUrlRepository.save(new ShortUrl("asdf2"));
        em.flush();
        em.clear();

        System.out.println(entity2);

        assertThat(entity1.getId()).isEqualTo(100000L);
        assertThat(entity2.getId()).isEqualTo(100001L);
    }
}