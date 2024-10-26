package com.aston.tour_service.model.recommendation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.aston.tour_service.model.weather.WeatherData;
import com.aston.tour_service.util.DataUtils;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TemperatureRecommendationTest {
    private final TemperatureRecommendation temperatureRecommendation = new TemperatureRecommendation();

    private static Stream<Arguments> temperatureDataProvider() {
        return Stream.of(
                Arguments.of(-5.0, "На улице холодно, одевайтесь потеплее\n"),
                Arguments.of(35.0, "На улице очень жарко, не забывайте пить воду\n"),
                Arguments.of(20.0, "На улице хорошая погода\n")
        );
    }

    @ParameterizedTest
    @MethodSource("temperatureDataProvider")
    @DisplayName("Test recommendation based on temperature")
    void givenTemperature_whenGetRecommendation_thenReturnsExpectedMessage(Double tempC, String expectedMessage) {
        // given
        WeatherData weatherData = DataUtils.getWeatherData();
        weatherData.getCurrent().setTempC(tempC);
        // when
        String recommendation = temperatureRecommendation.getRecommendation(weatherData);
        // then
        assertThat(recommendation).isEqualTo(expectedMessage);
    }
}
