package com.fiveExceptions.controller;

import com.fiveExceptions.dto.WeatherInfoResponse;
import com.fiveExceptions.dto.WeatherRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/api/weather")
public class WeatherInfoController {

    @PostMapping
    public WeatherInfoResponse getWeather(@RequestBody WeatherRequest weatherRequest) {
        String uri = "http://api.weatherapi.com/v1/current.json?key=" + weatherRequest.getKey() + "&q=" + weatherRequest.getLocation()
                + "&aqi=" + weatherRequest.getAirQualityData();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, WeatherInfoResponse.class);
    }
}
