package com.vacv.destination.service;

import com.vacv.destination.client.SoftVoyageClient;
import com.vacv.destination.client.dto.XML;
import com.vacv.destination.helper.XmlConverter;
import com.vacv.destination.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBException;

@Service
public class SoftVoyageService {
    @Autowired
    private SoftVoyageClient softVoyageClient;
    @Autowired
    private DestinationRepository destinationRepository;

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
                                            System.out.println(destination.getDestCode() + ":" + destination.getDestName());
                                            destinationRepository.putItem(destination);
                                        });
                            }
                        }));
    }
}
