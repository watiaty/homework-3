package com.aston.tour_service.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.aston.tour_service.model.AttractionType;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class AttractionResponseDTO {
    private Long id;
    private String name;
    private Date creationDate;
    private String description;
    private AttractionType type;
    private InnerLocalityResponseDTO locality;
}
