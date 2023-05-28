package com.vacv.destination.service;

import com.vacv.destination.client.SoftVoyageClient;
import com.vacv.destination.client.dto.Destination;
import com.vacv.destination.repository.DestinationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.bind.JAXBException;

import static org.mockito.Mockito.*;

public class SoftVoyageServiceTest {

    @Mock
    private SoftVoyageClient softVoyageClient;

    @Mock
    private DestinationRepository destinationRepository;

    @InjectMocks
    private SoftVoyageService softVoyageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void loadDestinations_getTwoDestination_addedTwoDestinationSuccessfully() throws JAXBException {
        String gatewayXml = "<XML>" +
                "    <GATEWAYS>" +
                "        <GATEWAY>" +
                "<DESTINATIONS_GROUPS>" +
                "<GROUP>" +
                "<GROUP_CODE>10,14,73</GROUP_CODE>" +
                "<GROUP_NAME>" +
                "<![CDATA[Dominican Republic]]>" +
                "</GROUP_NAME>" +
                "<DESTINATIONS>" +
                "<DESTINATION>" +
                "<DEST_CODE>CODE1</DEST_CODE>" +
                "<DEST_NAME>" +
                "<![CDATA[Destination 1]]>" +
                "</DEST_NAME>" +
                "</DESTINATION>" +
                "<DESTINATION>" +
                "<DEST_CODE>CODE2</DEST_CODE>" +
                "<DEST_NAME>" +
                "<![CDATA[Destination 2]]>" +
                "</DEST_NAME>" +
                "</DESTINATION>" +
                "</DESTINATIONS>" +
                "</GROUP>" +
                "</DESTINATIONS_GROUPS>" +
                "</GATEWAY>" +
                "=</GATEWAYS>" +
                "</XML>";
        when(softVoyageClient.getXMlGateways()).thenReturn(gatewayXml);

        Destination destination1 = new Destination();
        destination1.setDestCode("CODE1");
        destination1.setDestName("Destination 1");

        Destination destination2 = new Destination();
        destination2.setDestCode("CODE2");
        destination2.setDestName("Destination 2");

        softVoyageService.loadDestinations();

        verify(softVoyageClient, times(1)).getXMlGateways();
        verify(destinationRepository, times(1)).putItem(destination1);
        verify(destinationRepository, times(1)).putItem(destination2);

    }
}

