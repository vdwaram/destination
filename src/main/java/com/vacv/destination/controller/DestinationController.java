package com.vacv.destination.controller;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.converter.DestinationModelConverter;
import com.vacv.destination.exception.InvalidException;
import com.vacv.destination.openapi.controller.DestinationsApi;
import com.vacv.destination.openapi.dto.DestinationDto;
import com.vacv.destination.openapi.dto.PatchDestinationDto;
import com.vacv.destination.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/destinations")
@RequiredArgsConstructor
public class DestinationController implements DestinationsApi {
    private final DestinationService destinationService;
    private final DestinationModelConverter destinationModelConverter;

    @GetMapping("/{code}")
    @Override
    public ResponseEntity<DestinationDto> destinationsCodeGet(@PathVariable String code) {
        Destination destination = destinationService.getDestination(code);
        return ResponseEntity.ok(destinationModelConverter.convertToDto(destination));
    }

    @DeleteMapping("/{code}")
    @Override
    public ResponseEntity<Void> destinationsCodeDelete(@PathVariable String code) {
        destinationService.deleteDestination(code);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{code}")
    @Override
    public ResponseEntity<Void> destinationsCodePatch(@PathVariable String code,
                                                      @RequestBody PatchDestinationDto destinationDto) {
        boolean containsOnlyAlphabetic = destinationDto.getName().chars().allMatch(Character::isAlphabetic);
        if(!containsOnlyAlphabetic) {
            throw new InvalidException("Provide name is not Alphabetic");
        }
        destinationService.updateDestination(code, destinationModelConverter.convertToEntity(destinationDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<DestinationDto>> destinationsGet() {
        List<Destination> destinations = destinationService.getDestinations();
        List<DestinationDto> destinationDtos = destinations.stream().map(destination -> destinationModelConverter.convertToDto(destination)).toList();
        return ResponseEntity.ok(destinationDtos);
    }
}
