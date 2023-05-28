package com.vacv.destination.repository;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DestinationRepository {
    private Map<String, Destination> destinationMap = new ConcurrentHashMap<>();

    public void putItem(Destination destination) {
        destinationMap.putIfAbsent(destination.getDestCode(), destination);

    }

    public Destination findDestination(String code) {
        Destination destination = destinationMap.get(code);
        if (destination == null) {
            throw new NotFoundException("Failed to find given code");
        }
        return destination;
    }

    public void deleteDestination(String code) {
        destinationMap.remove(code);
    }

    public void updateDestination(Destination destination) {
        destinationMap.put(destination.getDestCode(), destination);
    }

    public List<Destination> getAllDestinations() {
        return destinationMap.values().stream().toList();
    }
}
