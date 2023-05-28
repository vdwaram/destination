package com.vacv.destination.client.dto;

import lombok.*;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Destination {
    @XmlElement(name = "DEST_CODE")
    private String destCode;

    @XmlElement(name = "DEST_NAME")
    private String destName;

    @XmlElement(name = "DURATIONS")
    private String durations;

    @XmlElement(name = "HOTELS")
    private String hotels;
}
