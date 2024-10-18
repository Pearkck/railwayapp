package com.kotchakorn.railwayapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StationDto {

    private Long stationId;
    private String stationName;
    private String location;
    private String contactInfo;
}
