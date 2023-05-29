package com.vacv.destination.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SoftVoyageCacheInitializer implements CommandLineRunner {

    private final SoftVoyageService softVoyageService;

    @Override
    public void run(String... args) throws Exception {
        softVoyageService.loadDestinations();
    }
}
