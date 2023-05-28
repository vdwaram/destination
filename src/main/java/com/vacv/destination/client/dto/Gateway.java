package com.vacv.destination.client.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Gateway {
    @XmlElement(name = "GATEWAY_CODE")
    private String gatewayCode;

    @XmlElement(name = "GATEWAY_NAME")
    private String gatewayName;

    @XmlElementWrapper(name = "DESTINATIONS_GROUPS")
    @XmlElement(name = "GROUP")
    private List<Group> destinationGroups;
}
