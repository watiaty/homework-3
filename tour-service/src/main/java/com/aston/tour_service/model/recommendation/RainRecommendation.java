package com.aston.tour_service.model.recommendation;

import com.aston.tour_service.model.weather.WeatherData;

public class RainRecommendation implements RecommendationStrategy {
    @Override
    public String getRecommendation(WeatherData weatherData) {
        Double precipMm = weatherData.getCurrent().getPrecipMm();
        if (precipMm != null && precipMm > 0) {
            return "Идет дождь, возьмите зонтик\n";
        }
        return "";
    }
}
