package com.aston.tour_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aston.tour_service.model.Attraction;
import com.aston.tour_service.model.AttractionType;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Page<Attraction> findAllByType(AttractionType type, Pageable pageable);

    Page<Attraction> findAllByLocalityId(Long id, Pageable pageable);
}
