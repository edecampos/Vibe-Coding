package com.example.houses.api;

import com.example.houses.model.House;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.core.ParameterizedTypeReference;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RentCastApiClient {

    private static final Logger logger = LoggerFactory.getLogger(RentCastApiClient.class);

    @Value("${rentcast.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<House> fetchHousesForSale(String address, int radiusMiles) {
        try {
            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
            String apiUrl = String.format(
                "https://api.rentcast.io/v1/properties?address=%s&radius=%d&status=for_sale",
                encodedAddress, radiusMiles
            );
            logger.info("Calling RentCast API URL: {}", apiUrl);

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            headers.set("X-Api-Key", apiKey);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
            );

            List<Map<String, Object>> rawList = response.getBody();
            if (rawList == null) return List.of();

            return rawList.stream().map(map -> {
                House h = new House();
                h.setId(map.get("id") != null ? String.valueOf(map.get("id")) : null);
                h.setAddress(map.get("formattedAddress") != null ? String.valueOf(map.get("formattedAddress")) : null);
                h.setLatitude(map.get("latitude") != null ? Double.valueOf(String.valueOf(map.get("latitude"))) : null);
                h.setLongitude(map.get("longitude") != null ? Double.valueOf(String.valueOf(map.get("longitude"))) : null);
                /*h.setPrice(map.get("price") != null ? Double.valueOf(String.valueOf(map.get("price"))) : null);
                */
                h.setPrice(map.get("lastSalePrice") != null ? Double.valueOf(String.valueOf(map.get("lastSalePrice"))) : null);
                h.setSquareFootage(map.get("squareFootage") != null ? Double.valueOf(String.valueOf(map.get("squareFootage"))) : null);
                return h;
            }).collect(Collectors.toList());
        } catch (HttpClientErrorException e) {
            logger.error("HTTP error from RentCast API: {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
        } catch (ResourceAccessException e) {
            logger.error("Network error when calling RentCast API: {}", e.getMessage());
        } catch (RestClientException e) {
            logger.error("General error when calling RentCast API: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error in RentCastApiClient: ", e);
        }
        return List.of(); // Return empty list on error
    }
}