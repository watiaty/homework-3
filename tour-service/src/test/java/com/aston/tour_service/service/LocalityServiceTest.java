package com.aston.tour_service.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.aston.tour_service.exception.LocalityAlreadyExistException;
import com.aston.tour_service.exception.LocalityNotFoundException;
import com.aston.tour_service.model.Locality;
import com.aston.tour_service.repository.LocalityRepository;
import com.aston.tour_service.service.impl.LocalityServiceImpl;
import com.aston.tour_service.util.DataUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LocalityServiceTest {
    @Mock
    private LocalityRepository localityRepository;

    @InjectMocks
    private LocalityServiceImpl localityService;

    @Test
    @DisplayName("Test save locality functionality")
    void givenLocalityToSave_whenCreate_thenRepositoryIsCalled() {
        // given
        Locality localityToSave = DataUtils.getHomelLocalityTransient();
        BDDMockito.given(localityService.create(localityToSave))
                .willReturn(DataUtils.getHomelLocalityPersisted());
        // when
        Locality savedLocality = localityService.create(localityToSave);
        // then
        assertThat(savedLocality).isNotNull();
        verify(localityRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Test save locality functionality")
    void givenLocalityToSave_whenCreate_thenThrowsException() {
        // given
        Locality localityToSave = DataUtils.getHomelLocalityTransient();
        BDDMockito.given(localityRepository.findFirstByNameAndRegion(localityToSave.getName(), localityToSave.getRegion()))
                .willReturn(Optional.ofNullable(DataUtils.getHomelLocalityPersisted()));
        // when
        assertThrows(LocalityAlreadyExistException.class, () -> localityService.create(localityToSave));
        // then
        verify(localityRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test find locality by id functionality")
    void givenId_whenGetById_thenRepositoryIsCalled() {
        // given
        Long id = 1L;
        BDDMockito.given(localityRepository.findById(any(Long.class)))
                .willReturn(Optional.ofNullable(DataUtils.getHomelLocalityPersisted()));
        // when
        Locality obtainedLocality = localityService.findById(id);
        // then
        assertThat(obtainedLocality).isNotNull();
        verify(localityRepository, times(1)).findById(any());
    }

    @Test
    @DisplayName("Test find locality by id functionality")
    void givenId_whenGetById_thenExceptionIsThrow() {
        // given
        Long id = 1L;
        BDDMockito.given(localityRepository.findById(anyLong()))
                .willReturn(Optional.empty());
        // when and then
        assertThrows(LocalityNotFoundException.class, () -> localityService.findById(id));
    }
}
