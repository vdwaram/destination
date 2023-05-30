package com.vacv.destination.client;

import com.vacv.destination.config.SoftVoyageClientConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class SoftVoyageClient {
    private  final SoftVoyageClientConfig softVoyageClientConfig;

    public String getXMlGateways() {
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configure -> configure.defaultCodecs().maxInMemorySize(softVoyageClientConfig.getBuffersize()))
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .build();


        return webClient.get()
                .uri(softVoyageClientConfig.getUrl())
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
