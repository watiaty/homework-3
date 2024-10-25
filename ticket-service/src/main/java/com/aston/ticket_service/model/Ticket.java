package com.aston.ticket_service.model;

import com.aston.ticket_service.enums.TicketStatus;
import com.aston.ticket_service.enums.TicketType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime issueDate;

    private LocalDateTime eventDate;

    private Double price;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;

    @Enumerated(EnumType.ORDINAL)
    private TicketType type;

    private Long userId;

    private Long attractionId;
}
