package com.edigitalnepal.ems.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@ConfigurationProperties(prefix = "application.jwt")
@Component
public class JWTConfig {
    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterInMilSeconds;

    public JWTConfig() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Integer getTokenExpirationAfterInMilSeconds() {
        return tokenExpirationAfterInMilSeconds;
    }

    public void setTokenExpirationAfterInMilSeconds(Integer tokenExpirationAfterInMilSeconds) {
        this.tokenExpirationAfterInMilSeconds = tokenExpirationAfterInMilSeconds;
    }

    @Bean
    public SecretKey getSecretKeyForSigning() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
