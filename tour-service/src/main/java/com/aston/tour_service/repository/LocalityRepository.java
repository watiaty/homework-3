package com.aston.tour_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aston.tour_service.model.Locality;

import java.util.Optional;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    Optional<Locality> findFirstByNameAndRegion(String name, String region);
}
