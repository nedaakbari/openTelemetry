package org.example.downstream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import static org.example.downstream.PriceController.LOGGER;

@Service
public class PriceClient {
    private final RestTemplate restTemplate;

    @Value("${base}")
    String baseUrl;

    public PriceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Price getPrice(@PathVariable("id") long productId) {
        LOGGER.info("Fetching Price Details With Product Id {}", productId);
        String url = String.format("%s/price/%d", baseUrl, productId);
        ResponseEntity<Price> price = restTemplate.getForEntity(url, Price.class);
        return price.getBody();
    }
}
