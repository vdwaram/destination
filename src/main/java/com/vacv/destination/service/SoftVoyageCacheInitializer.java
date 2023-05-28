package com.vacv.destination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SoftVoyageCacheInitializer implements CommandLineRunner {

    @Autowired
    private SoftVoyageService softVoyageService;


    @Override
    public void run(String... args) throws Exception {
        softVoyageService.loadDestinations();
    }
}
