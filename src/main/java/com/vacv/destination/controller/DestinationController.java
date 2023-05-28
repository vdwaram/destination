package com.vacv.destination.controller;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.converter.DestinationModelConverter;
import com.vacv.destination.dto.DestinationDto;
import com.vacv.destination.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationController {
    private final DestinationService destinationService;
    private final DestinationModelConverter destinationModelConverter;

    @GetMapping("/{code}")
    public ResponseEntity<DestinationDto> getDestinationById(@PathVariable String code) {
        Destination destination = destinationService.getDestination(code);
        return ResponseEntity.ok(destinationModelConverter.convertToDto(destination));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteDestinationById(@PathVariable String code) {
        destinationService.deleteDestination(code);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{code}")
    public ResponseEntity<Void> updateDestinationById(@PathVariable String code,
                                                      @RequestBody DestinationDto destinationDto) {
        destinationService.updateDestination(code, destinationModelConverter.convertToEntity(destinationDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DestinationDto>> getDestinations() {
        List<Destination> destinations = destinationService.getDestinations();
        List<DestinationDto> destinationDtos = destinations.stream().map(destination -> destinationModelConverter.convertToDto(destination)).toList();
        return ResponseEntity.ok(destinationDtos);
    }
}
