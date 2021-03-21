package me.saru.urlshortner.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 단축된 URL 앞에 붙는 호스트 값을 application.yml 에서 가져온다
 */
@Configuration
@ConfigurationProperties(prefix = "short-server")
public class ConfigProperty {

    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
