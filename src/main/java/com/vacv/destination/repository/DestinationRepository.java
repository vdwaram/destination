package com.vacv.destination.repository;

import com.vacv.destination.client.dto.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

@Repository
public class DestinationRepository {

    private final CacheManager cacheManager;

    @Autowired
    public DestinationRepository(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void putItem(Destination destination) {
        Cache cache = cacheManager.getCache("destinations");
        cache.putIfAbsent(destination.getDestCode(), destination);
    }
}
