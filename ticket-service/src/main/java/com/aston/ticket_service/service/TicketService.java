package com.aston.ticket_service.service;

import com.aston.ticket_service.Dto.TicketDto;

public interface TicketService {

    TicketDto bookTicket(TicketDto ticketDto);

    TicketDto cancelBookTicket(TicketDto ticketDto);

    TicketDto exchangeTicket(TicketDto ticketDto);

    TicketDto cancelTicket(TicketDto ticketDto);

}
