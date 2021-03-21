package me.saru.urlshortner.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * id값이 1부터 시작하면 단축된 Url 이 너무 짧기 때문에 100000 부터 증가하도록 한다
 */
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "seq", initialValue = 100000)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime created;

    @Column(length = 1000, unique = true, nullable = false)
    private String url;

    @Column(nullable = false)
    private Long count = 0L;

    public ShortUrl(String url) {
        this.url = url;
    }

    public void increaseCount() {
        this.count++;
    }
}
