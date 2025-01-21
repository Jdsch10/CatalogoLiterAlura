package com.literalura.catalogoliteralura.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiGutenbergClient {

    private static final String BASE_URL = "https://gutendex.com/books/";

    private final RestTemplate restTemplate;

    public ApiGutenbergClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchBookByTitle(String title) {
        String url = BASE_URL + "?search=" + title;
        return restTemplate.getForObject(url, String.class);
    }
}