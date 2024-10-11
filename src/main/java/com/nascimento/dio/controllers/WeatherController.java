package com.nascimento.dio.controllers;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nascimento.dio.model.City;
import com.nascimento.dio.model.WeatherData;
import com.nascimento.dio.services.WeatherService;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("weatherData")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService weatherService) {
        this.service = weatherService;
    }
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("city", new City());
        return "index";
    }

    @PostMapping("/weather")
    @Cacheable(value = "weatherCache", key = "#city.name")
    public String getWeather(@ModelAttribute City city, Model model){
        WeatherData weatherData = service.getWeatherByCity(city.getName());
        model.addAttribute("weatherData", weatherData);
        return "index";
    }

    @Scheduled(fixedRate = 15000)
    @CacheEvict(value = "weatherCache", allEntries = true)
    public void clearCache(){
        System.out.println("Cache limpo");
    }

}
