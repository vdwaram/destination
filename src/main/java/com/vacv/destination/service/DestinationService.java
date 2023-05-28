package com.vacv.destination.service;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public Destination getDestination(String code) {
        return destinationRepository.findDestination(code);
    }

    public void deleteDestination(String code) {
        destinationRepository.deleteDestination(code);
    }

    public void updateDestination(String code, Destination destination) {
        Destination existingDestination = destinationRepository.findDestination(code);
        existingDestination.setDestName(destination.getDestName());
        destinationRepository.updateDestination(existingDestination);
    }
}
