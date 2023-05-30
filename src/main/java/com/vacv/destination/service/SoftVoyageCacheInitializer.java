package com.vacv.destination.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SoftVoyageCacheInitializer implements CommandLineRunner {

    private final SoftVoyageService softVoyageService;

    @Override
    public void run(String... args) throws Exception {
        try {
            softVoyageService.loadDestinations();
        }
        catch (Exception exp) {
            log.error("Failed to initialize destinations cache", exp);
            throw exp;
        }
    }
}
