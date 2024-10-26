package com.aston.tour_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aston.tour_service.exception.LocalityAlreadyExistException;
import com.aston.tour_service.exception.LocalityNotFoundException;
import com.aston.tour_service.model.Locality;
import com.aston.tour_service.repository.LocalityRepository;
import com.aston.tour_service.service.LocalityService;

@Service
@RequiredArgsConstructor
public class LocalityServiceImpl implements LocalityService {

    private final LocalityRepository localityRepository;

    /**
     * Поиск Locality по ID
     *
     * @param id ID для поиска
     * @return Возвращает объект Locality
     * @throws LocalityNotFoundException выбрасывает исключение, если объект не найден
     */
    @Override
    public Locality findById(Long id) {
        return localityRepository.findById(id).orElseThrow(() -> new LocalityNotFoundException(id));
    }

    /**
     * Создает новый объект Locality
     *
     * @param locality Объект для сохранения
     * @return Возвращает сохраненный объект
     * @throws LocalityAlreadyExistException возвращает исключение, если объект с такими названием и регионом уже существует
     */
    @Override
    public Locality create(Locality locality) {
        localityRepository.findFirstByNameAndRegion(locality.getName(), locality.getRegion())
                .ifPresent(value -> {
                    throw new LocalityAlreadyExistException(locality.getName(), locality.getRegion());
                });

        return localityRepository.save(locality);
    }
}
