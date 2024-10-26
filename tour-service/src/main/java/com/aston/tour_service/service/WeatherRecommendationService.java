package com.aston.tour_service.service;

import com.aston.tour_service.model.weather.WeatherData;

public interface WeatherRecommendationService {
    String getRecommendation(WeatherData weatherData);
}
