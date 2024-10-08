package com.nascimento.dio.services;

import com.nascimento.dio.client.WeatherApiClient;
import com.nascimento.dio.model.CurrentConditions;
import com.nascimento.dio.model.WeatherData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;

@Service
public class WeatherService {

    private final WeatherApiClient client;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.client = weatherApiClient;
    }

    public WeatherData getWeatherByCity(String cidade) {

        return client.getWeatherData(cidade);
    }
}
