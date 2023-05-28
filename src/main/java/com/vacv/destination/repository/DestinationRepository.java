package com.vacv.destination.repository;

import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.exception.NotFoundException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

@Repository
public class DestinationRepository {

    private final CacheManager cacheManager;

    public DestinationRepository(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void putItem(Destination destination) {
        Cache cache = cacheManager.getCache("destinations");
        cache.putIfAbsent(destination.getDestCode(), destination);
    }

    public Destination findDestination(String code) {
        Cache cache = cacheManager.getCache("destinations");
        Cache.ValueWrapper valueWrapper = cache.get(code);
        if (valueWrapper == null) {
            throw new NotFoundException("Failed to find given code");
        }
        return (Destination) valueWrapper.get();
    }

    public void deleteDestination(String code) {
        Cache cache = cacheManager.getCache("destinations");
        cache.evictIfPresent(code);
    }

    public void updateDestination(Destination destination) {
        Cache cache = cacheManager.getCache("destinations");
        cache.put(destination.getDestCode(), destination);
    }
}
