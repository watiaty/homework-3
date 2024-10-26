package com.aston.tour_service.mappers;

import com.aston.tour_service.dtos.request.AddAttractionRequestDTO;
import com.aston.tour_service.dtos.response.AttractionResponseDTO;
import com.aston.tour_service.dtos.response.InnerLocalityResponseDTO;
import com.aston.tour_service.model.Assistance;
import com.aston.tour_service.model.Attraction;
import com.aston.tour_service.model.Locality;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-26T14:10:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class AttractionMapperImpl implements AttractionMapper {

    @Override
    public AttractionResponseDTO attractionToAttractionResponseDTO(Attraction attraction) {
        if ( attraction == null ) {
            return null;
        }

        AttractionResponseDTO.AttractionResponseDTOBuilder attractionResponseDTO = AttractionResponseDTO.builder();

        attractionResponseDTO.id( attraction.getId() );
        attractionResponseDTO.name( attraction.getName() );
        attractionResponseDTO.creationDate( attraction.getCreationDate() );
        attractionResponseDTO.description( attraction.getDescription() );
        attractionResponseDTO.type( attraction.getType() );
        attractionResponseDTO.locality( localityToInnerLocalityResponseDTO( attraction.getLocality() ) );

        return attractionResponseDTO.build();
    }

    @Override
    public List<AttractionResponseDTO> attractionListToAttractionListResponseDTO(List<Attraction> attractions) {
        if ( attractions == null ) {
            return null;
        }

        List<AttractionResponseDTO> list = new ArrayList<AttractionResponseDTO>( attractions.size() );
        for ( Attraction attraction : attractions ) {
            list.add( attractionToAttractionResponseDTO( attraction ) );
        }

        return list;
    }

    @Override
    public Attraction attractionResponseDTOToAttraction(AddAttractionRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Attraction.AttractionBuilder attraction = Attraction.builder();

        attraction.name( dto.getName() );
        attraction.creationDate( dto.getCreationDate() );
        attraction.description( dto.getDescription() );
        attraction.type( dto.getType() );
        List<Assistance> list = dto.getAssistance();
        if ( list != null ) {
            attraction.assistance( new ArrayList<Assistance>( list ) );
        }

        return attraction.build();
    }

    protected InnerLocalityResponseDTO localityToInnerLocalityResponseDTO(Locality locality) {
        if ( locality == null ) {
            return null;
        }

        InnerLocalityResponseDTO.InnerLocalityResponseDTOBuilder innerLocalityResponseDTO = InnerLocalityResponseDTO.builder();

        innerLocalityResponseDTO.id( locality.getId() );
        innerLocalityResponseDTO.name( locality.getName() );
        innerLocalityResponseDTO.region( locality.getRegion() );
        innerLocalityResponseDTO.latitude( locality.getLatitude() );
        innerLocalityResponseDTO.longitude( locality.getLongitude() );

        return innerLocalityResponseDTO.build();
    }
}
