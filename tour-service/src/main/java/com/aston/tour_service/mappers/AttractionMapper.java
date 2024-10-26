package com.aston.tour_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.aston.tour_service.dtos.request.AddAttractionRequestDTO;
import com.aston.tour_service.dtos.response.AttractionResponseDTO;
import com.aston.tour_service.model.Attraction;

import java.util.List;

@Mapper
public interface AttractionMapper {

    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    AttractionResponseDTO attractionToAttractionResponseDTO(Attraction attraction);

    List<AttractionResponseDTO> attractionListToAttractionListResponseDTO(List<Attraction> attractions);

    Attraction attractionResponseDTOToAttraction(AddAttractionRequestDTO dto);
}
