package com.aston.tour_service.model.recommendation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.aston.tour_service.model.weather.WeatherData;
import com.aston.tour_service.util.DataUtils;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WindRecommendationTest {
    private final WindRecommendation windRecommendation = new WindRecommendation();

    private static Stream<Arguments> windDataProvider() {
        return Stream.of(
                Arguments.of(25.0, "Сильный ветер, будьте аккуратнее\n"),
                Arguments.of(15.0, ""),
                Arguments.of(null, "")
        );
    }

    @ParameterizedTest
    @MethodSource("windDataProvider")
    @DisplayName("Test recommendation based on wind speed")
    void givenWindSpeed_whenGetRecommendation_thenReturnsExpectedMessage(Double windSpeed, String expectedMessage) {
        // given
        WeatherData weatherData = DataUtils.getWeatherData();
        weatherData.getCurrent().setWindKph(windSpeed);
        // when
        String recommendation = windRecommendation.getRecommendation(weatherData);
        // then
        assertThat(recommendation).isEqualTo(expectedMessage);
    }
}