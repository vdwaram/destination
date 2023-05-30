package com.vacv.destination.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "softvoyage.client")
@NoArgsConstructor
@Getter
@Setter
public class SoftVoyageClientConfig {
    private int buffersize;
    private String url;
}
