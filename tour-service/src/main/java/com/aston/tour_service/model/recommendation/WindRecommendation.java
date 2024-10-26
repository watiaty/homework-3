package com.aston.tour_service.model.recommendation;

import com.aston.tour_service.model.weather.WeatherData;

public class WindRecommendation implements RecommendationStrategy {
    @Override
    public String getRecommendation(WeatherData weatherData) {
        Double windKph = weatherData.getCurrent().getWindKph();
        if (windKph != null && windKph > 20) {
            return "Сильный ветер, будьте аккуратнее\n";
        }
        return "";
    }
}
