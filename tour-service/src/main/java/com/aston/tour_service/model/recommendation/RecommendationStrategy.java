package com.aston.tour_service.model.recommendation;

import com.aston.tour_service.model.weather.WeatherData;

public interface RecommendationStrategy {
    String getRecommendation(WeatherData weatherData);
}
