package com.vacv.destination.converter;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.openapi.dto.DestinationDto;
import com.vacv.destination.openapi.dto.PatchDestinationDto;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DestinationModelConverter {

    public DestinationDto convertToDto(Destination destination) {
        DestinationDto destinationDto = new DestinationDto();
        destinationDto.code(destination.getDestCode())
                .name(destination.getDestName())
                .setHotelCodes(Arrays.asList(destination.getHotels().split(",")));

        return destinationDto;
    }

    public Destination convertToEntity(DestinationDto destinationDto) {
        return Destination.builder()
                .destCode(destinationDto.getCode())
                .destName(destinationDto.getName())
                .build();
    }
    public Destination convertToEntity(PatchDestinationDto destinationDto) {
        return Destination.builder()
                .destName(destinationDto.getName())
                .build();
    }
}
