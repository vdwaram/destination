package com.vacv.destination.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class DestinationDto {
    private String code;
    private String name;
    private List<String> hotels;
}
