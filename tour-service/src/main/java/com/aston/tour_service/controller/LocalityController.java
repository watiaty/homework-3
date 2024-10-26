package com.aston.tour_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.aston.tour_service.dtos.request.AddLocalityRequestDTO;
import com.aston.tour_service.dtos.response.LocalityResponseDto;
import com.aston.tour_service.mappers.LocalityMapper;
import com.aston.tour_service.model.Locality;
import com.aston.tour_service.service.LocalityService;
import com.aston.tour_service.service.WeatherService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/locality")
public class LocalityController {
    private final LocalityService localityService;
    private final WeatherService weatherService;

    /**
     * Добавляет новое местоположение
     *
     * @param dto Объект для создания нового объекта Locality. {@link AddLocalityRequestDTO}
     * @return Возвращает DTO {@link LocalityResponseDto}.
     * Возвращает статус 201
     */
    @PostMapping
    @Operation(summary = "Добавление местоположения", description = "Добавить местоположение")
    public ResponseEntity<LocalityResponseDto> createLocality(@RequestBody AddLocalityRequestDTO dto) {
        Locality locality = LocalityMapper.INSTANCE.addLocalityRequestDTOToLocality(dto);

        locality = localityService.create(locality);

        LocalityResponseDto result = LocalityMapper.INSTANCE.localityToLocalityResponseDTO(locality);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Получает рекомендации по погоде
     *
     * @param id ID Locality
     * @return Возвращает строку с рекомендациями
     */
    @GetMapping("/recommendation")
    @Cacheable(value = "weatherCache", key = "#id")
    public ResponseEntity<String> getRecommendation(@RequestParam Long id) {
        Locality locality = localityService.findById(id);
        String coordinates = locality.getLatitude() + "," + locality.getLongitude();

        String result = weatherService.getRecommendationByCoordinates(coordinates);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
