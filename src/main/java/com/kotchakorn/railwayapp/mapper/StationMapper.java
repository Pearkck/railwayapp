package com.kotchakorn.railwayapp.mapper;

import com.kotchakorn.railwayapp.dto.StationDto;
import com.kotchakorn.railwayapp.entity.Station;

public class StationMapper {

    public static StationDto mapToStationDto(Station station){
        return new StationDto(
                station.getStationId(),
                station.getStationName(),
                station.getLocation(),
                station.getContactInfo()
        );
    }

    public static Station mapToStation(StationDto stationDto){
        return new Station(
                stationDto.getStationId(),
                stationDto.getStationName(),
                stationDto.getLocation(),
                stationDto.getContactInfo()
        );
    }
}
