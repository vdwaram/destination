package com.vacv.destination.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SoftVoyageClient {


    public String getXMlGateways() {
        int maxBufferSize = 1048576; // 1 MB
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configure -> configure.defaultCodecs().maxInMemorySize(maxBufferSize))
                .build();
        WebClient webClient = WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .build();


        return webClient.get()
                .uri("https://lib.softvoyage.com/cgi-bin/gate_dest_hotels.xml?code_ag=ACV&alias=ACV&language=en&tour_to_display=VAC&with_cdata=y&with_hotel_links=y")
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
