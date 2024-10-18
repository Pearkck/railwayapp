package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.dto.StationDto;

import java.util.List;

public interface StationService {
    StationDto createStation(StationDto stationDto);

    StationDto getStationById(Long stationId);

    List<StationDto> getAllStations();

    StationDto updateStation(Long stationId, StationDto updatedStation);

    void deleteStation(Long stationId);
}
