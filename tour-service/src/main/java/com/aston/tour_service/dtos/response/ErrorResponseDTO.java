package com.aston.tour_service.dtos.response;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private String message;
    private String status;
}
