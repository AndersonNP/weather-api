package com.nascimento.dio.controllers;

import com.nascimento.dio.client.WeatherApiClient;
import com.nascimento.dio.model.WeatherData;
import com.nascimento.dio.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService weatherService) {
        this.service = weatherService;
    }
    @GetMapping("/up")
    public String isUp(){
        return "UP";
    }

    @GetMapping("/{cidade}")
    public WeatherData getWeatherByCity(@PathVariable String cidade){

        return service.getWeatherByCity(cidade);
    }

}
