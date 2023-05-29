package com.vacv.destination.service;

import com.vacv.destination.client.SoftVoyageClient;
import com.vacv.destination.client.dto.XML;
import com.vacv.destination.helper.XmlConverter;
import com.vacv.destination.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBException;

@Service
@Slf4j
@RequiredArgsConstructor
public class SoftVoyageService {

    private final SoftVoyageClient softVoyageClient;

    private final DestinationRepository destinationRepository;

    public void loadDestinations() throws JAXBException {

        String gatewayXml = softVoyageClient.getXMlGateways();
        XmlConverter<XML> xmlConverter = new XmlConverter<>();
        XML data = xmlConverter.unmarshal(XML.class, gatewayXml);
        data.getGateways().getGatewayList()
                .forEach(gateway -> gateway.getDestinationGroups()
                        .forEach(destinationGroup ->
                        {
                            if (destinationGroup.getDestinations() != null) {
                                destinationGroup.getDestinations()
                                        .forEach(destination -> {
                                            log.info("Reading from xml "+ destination.getDestCode() + ":" + destination.getDestName());
                                            destinationRepository.putItem(destination);
                                        });
                            }
                        }));
    }
}
