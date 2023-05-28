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
public class Group {
    @XmlElement(name = "GROUP_CODE")
    private String groupCode;

    @XmlElement(name = "GROUP_NAME")
    private String groupName;

    @XmlElementWrapper(name = "DESTINATIONS")
    @XmlElement(name = "DESTINATION")
    private List<Destination> destinations;
}
