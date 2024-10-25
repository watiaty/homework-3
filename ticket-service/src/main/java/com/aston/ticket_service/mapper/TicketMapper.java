package com.aston.ticket_service.mapper;

import com.aston.ticket_service.Dto.TicketDto;
import com.aston.ticket_service.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    //    @Mapping(target = "address", ignore = true)
    TicketDto toUserDTO(Ticket ticket);

    Ticket fromDTO(TicketDto ticketDto);

}
