package com.aston.tour_service.service.impl;

import org.springframework.stereotype.Service;
import com.aston.tour_service.model.recommendation.HumidityRecommendation;
import com.aston.tour_service.model.recommendation.RainRecommendation;
import com.aston.tour_service.model.recommendation.TemperatureRecommendation;
import com.aston.tour_service.model.recommendation.VisibilityRecommendation;
import com.aston.tour_service.model.recommendation.WindRecommendation;
import com.aston.tour_service.model.weather.WeatherData;
import com.aston.tour_service.service.WeatherRecommendationService;

@Service
public class WeatherRecommendationServiceImpl implements WeatherRecommendationService {
    private final TemperatureRecommendation temperatureRecommendation;
    private final HumidityRecommendation humidityRecommendation;
    private final WindRecommendation windRecommendation;
    private final VisibilityRecommendation visibilityRecommendation;
    private final RainRecommendation rainRecommendation;

    public WeatherRecommendationServiceImpl() {
        this.temperatureRecommendation = new TemperatureRecommendation();
        this.humidityRecommendation = new HumidityRecommendation();
        this.windRecommendation = new WindRecommendation();
        this.visibilityRecommendation = new VisibilityRecommendation();
        this.rainRecommendation = new RainRecommendation();
    }

    /**
     * Получает рекомендации на оснавании погоды
     *
     * @param weatherData Характеристики погоды
     * @return Возвращает строку с рекомендациями
     */
    public String getRecommendation(WeatherData weatherData) {
        StringBuilder recommendations = new StringBuilder();
        recommendations.append(temperatureRecommendation.getRecommendation(weatherData));
        recommendations.append(humidityRecommendation.getRecommendation(weatherData));
        recommendations.append(windRecommendation.getRecommendation(weatherData));
        recommendations.append(visibilityRecommendation.getRecommendation(weatherData));
        recommendations.append(rainRecommendation.getRecommendation(weatherData));

        return recommendations.toString();
    }
}
