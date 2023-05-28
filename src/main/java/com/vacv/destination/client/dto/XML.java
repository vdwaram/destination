package com.vacv.destination.client.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@XmlRootElement(name = "XML")
@XmlAccessorType(XmlAccessType.FIELD)
public class XML {
    @XmlElement(name = "GATEWAYS")
    private Gateways gateways;

    public Gateways getGateways() {
        return gateways;
    }
}
