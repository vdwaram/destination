package com.vacv.destination.converter;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.dto.DestinationDto;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DestinationModelConverter {

    public DestinationDto convertToDto(Destination destination) {
        return DestinationDto.builder()
                .code(destination.getDestCode())
                .name(destination.getDestName())
                .hotels(Arrays.asList(destination.getHotels().split(",")))
                .build();
    }
}
