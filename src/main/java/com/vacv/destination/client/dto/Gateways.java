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
public class Gateways {
    @XmlElement(name = "GATEWAY")
    private List<Gateway> gatewayList;
}
