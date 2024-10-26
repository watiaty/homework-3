package com.aston.tour_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.aston.tour_service.client.WeatherClient;
import com.aston.tour_service.model.weather.WeatherData;
import com.aston.tour_service.service.WeatherRecommendationService;
import com.aston.tour_service.service.WeatherService;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherClient weatherClient;
    private final WeatherRecommendationService weatherRecommendationServiceImpl;

    @Value("${weather.api-key}")
    private String apiKey;

    /**
     * Получает рекомендации по погоде
     *
     * @param coordinates Долгота и широта
     * @return Возвращает строку с рекомендациями
     */
    public String getRecommendationByCoordinates(String coordinates) {
        WeatherData weatherData = getWeatherDataByCoordinates(coordinates);
        return weatherRecommendationServiceImpl.getRecommendation(weatherData);
    }

    /**
     * Получает характеристики погоды в определенном местоположении
     *
     * @param coordinates Долгота и широта
     * @return Возвращает погоду
     */
    private WeatherData getWeatherDataByCoordinates(String coordinates) {
        String aqi = "yes";
        return weatherClient.getWeather(apiKey, coordinates, aqi);
    }
}
