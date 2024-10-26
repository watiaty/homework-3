package com.aston.tour_service.service;

import org.springframework.stereotype.Service;
import com.aston.tour_service.model.Locality;

@Service
public interface LocalityService {
    Locality findById(Long id);

    Locality create(Locality locality);
}
