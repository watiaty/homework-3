package com.aston.ticket_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("tickets")
public class TicketController {

    public ResponseEntity<Void> bookTicket() {
        return ResponseEntity.ok().build();
    }
}
