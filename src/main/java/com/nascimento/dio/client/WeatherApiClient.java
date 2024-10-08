package com.nascimento.dio.client;

import com.nascimento.dio.exception.ApiError;
import com.nascimento.dio.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherApiClient {

    private final RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(String cidade){
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl + cidade)
                .queryParam("unitGroup", "metric")
                .queryParam("contentType", "json")
                .queryParam("key", apiKey)
                .toUriString();

        try {
            ResponseEntity<WeatherData> responseEntity = restTemplate.getForEntity(url, WeatherData.class);

            if(responseEntity.getStatusCode().is2xxSuccessful()){
                return responseEntity.getBody();
            }else{
                ApiError apiError = handleApiError(responseEntity);
                throw new RuntimeException(apiError.getMessage());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao se comunicar com a API: " + e.getMessage());
        }

    }

    private ApiError handleApiError(ResponseEntity<WeatherData> responseEntity){
        ApiError apiError = new ApiError();
        apiError.setStatus(responseEntity.getStatusCodeValue());
        apiError.setMessage("Erro na API: " + responseEntity.getBody());
        return apiError;
    }
}
