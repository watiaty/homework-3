package com.aston.tour_service.model.recommendation;

import com.aston.tour_service.model.weather.WeatherData;

public class HumidityRecommendation implements RecommendationStrategy {
    @Override
    public String getRecommendation(WeatherData weatherData) {
        Integer humidity = weatherData.getCurrent().getHumidity();
        if (humidity > 70) {
            return "Высокая влажность\n";
        } else if (humidity < 30) {
            return "Низкая влажность\n";
        }
        return "";
    }
}
