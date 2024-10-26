package com.aston.tour_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.aston.tour_service.dtos.request.AddLocalityRequestDTO;
import com.aston.tour_service.dtos.response.LocalityResponseDto;
import com.aston.tour_service.model.Locality;

@Mapper
public interface LocalityMapper {
    LocalityMapper INSTANCE = Mappers.getMapper(LocalityMapper.class);

    @Mapping(source = "id", target = "id")
    LocalityResponseDto localityToLocalityResponseDTO(Locality locality);

    Locality addLocalityRequestDTOToLocality(AddLocalityRequestDTO dto);
}
