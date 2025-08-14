package com.example.demo.controller;

import com.example.demo.model.ForecastData;
import com.example.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast/tomorrow")
    public ResponseEntity<ForecastData> getTomorrowForecast() {
        ForecastData forecast = weatherService.getTomorrowForecast();
        return ResponseEntity.ok(forecast);
    }
}