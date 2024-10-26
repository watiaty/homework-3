package com.aston.tour_service.model.recommendation;

import com.aston.tour_service.model.weather.WeatherData;

public class TemperatureRecommendation implements RecommendationStrategy {
    @Override
    public String getRecommendation(WeatherData weatherData) {
        Double tempC = weatherData.getCurrent().getTempC();
        if (tempC < 0) {
            return "На улице холодно, одевайтесь потеплее\n";
        } else if (tempC > 30) {
            return "На улице очень жарко, не забывайте пить воду\n";
        } else {
            return "На улице хорошая погода\n";
        }
    }
}
