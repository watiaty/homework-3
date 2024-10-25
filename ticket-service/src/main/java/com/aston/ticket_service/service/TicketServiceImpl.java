package com.aston.ticket_service.service;

import com.aston.ticket_service.Dto.TicketDto;
import com.aston.ticket_service.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    @Override
    public TicketDto bookTicket(TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto cancelBookTicket(TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto exchangeTicket(TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto cancelTicket(TicketDto ticketDto) {
        return null;
    }
}
