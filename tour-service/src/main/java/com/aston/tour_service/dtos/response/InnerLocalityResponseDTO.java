package com.aston.tour_service.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class InnerLocalityResponseDTO {
    private Long id;
    private String name;
    private String region;
    private Double latitude;
    private Double longitude;
}
