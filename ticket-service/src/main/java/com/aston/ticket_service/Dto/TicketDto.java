package com.aston.ticket_service.Dto;

import com.aston.ticket_service.enums.TicketStatus;
import com.aston.ticket_service.enums.TicketType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDto {

    private final Long id;

    private final LocalDateTime issueDate;

    private final LocalDateTime eventDate;

    private final Double price;

    private final TicketStatus status;

    private final TicketType type;

    private final Long userId;

    private final Long attractionId;
}
