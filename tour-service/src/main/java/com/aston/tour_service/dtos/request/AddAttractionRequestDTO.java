package com.aston.tour_service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import com.aston.tour_service.model.Assistance;
import com.aston.tour_service.model.AttractionType;

import java.util.Date;
import java.util.List;

@Builder
@Getter
public class AddAttractionRequestDTO {
    @NotBlank(message = "Название не должно быть пустым")
    private String name;
    private Date creationDate;
    @NotBlank(message = "Описание не должно быть пустым")
    private String description;
    private AttractionType type;
    @Positive(message = "ID должно быть положительным")
    private Long localityId;
    private List<Assistance> assistance;
}
