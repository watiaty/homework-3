package com.aston.tour_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.aston.tour_service.model.Attraction;
import com.aston.tour_service.model.AttractionType;

public interface AttractionService {
    Attraction createAttraction(Attraction attraction);

    Attraction getById(Long id);

    Page<Attraction> getAllByType(AttractionType type, Pageable pageable);

    Page<Attraction> getAllByLocalityId(Long id, Pageable pageable);

    Attraction updateDescription(Long id, String shortDescription);

    void deleteAttractionById(Long id);
}
