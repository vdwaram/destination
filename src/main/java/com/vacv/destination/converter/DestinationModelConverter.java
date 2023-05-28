package com.vacv.destination.converter;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.dto.DestinationDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DestinationModelConverter {

    private final ModelMapper modelMapper;

    public DestinationDto convertToDto(Destination destination) {
        modelMapper.typeMap(Destination.class, DestinationDto.class)
                .addMappings(mapper -> mapper.map(src -> src.getDestCode(), DestinationDto::setCode))
                .addMappings(mapper -> mapper.map(src -> src.getDestName(), DestinationDto::setName))
                .addMappings(mapper -> mapper.map(src -> Arrays.asList(src.getHotels().split(",")), DestinationDto::setHotels));

        return modelMapper.map(destination, DestinationDto.class);
    }

    public Destination convertToEntity(DestinationDto destinationDto) {
        modelMapper.typeMap(DestinationDto.class, Destination.class)
                .addMappings(mapper -> mapper.map(DestinationDto::getCode, Destination::setDestCode))
                .addMappings(mapper -> mapper.map(DestinationDto::getName, Destination::setDestName))
                .addMappings(mapper -> mapper.map(DestinationDto::getHotels, Destination::setHotels));

        return modelMapper.map(destinationDto, Destination.class);
    }

    public List<DestinationDto> convertToDtoList(List<Destination> destinations) {
        Type destinationDtoListType = new TypeToken<List<DestinationDto>>() {}.getType();
        return modelMapper.map(destinations, destinationDtoListType);
    }
}
