package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.dto.StationDto;
import com.kotchakorn.railwayapp.entity.Station;
import com.kotchakorn.railwayapp.exceptions.ResourceNotFoundException;
import com.kotchakorn.railwayapp.mapper.StationMapper;
import com.kotchakorn.railwayapp.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StationServiceImpl implements StationService{

    private StationRepository stationRepository;

    @Override
    public StationDto createStation(StationDto stationDto) {
        Station station = StationMapper.mapToStation(stationDto);
        Station savedStation = stationRepository.save(station);
        return StationMapper.mapToStationDto(savedStation);
    }

    @Override
    public StationDto getStationById(Long stationId) {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new ResourceNotFoundException("Station is not exists with given id : " + stationId));
        return StationMapper.mapToStationDto(station);
    }

    @Override
    public List<StationDto> getAllStations() {
        List<Station> stations = stationRepository.findAll();
        return stations.stream().map(StationMapper::mapToStationDto)
                .collect(Collectors.toList());
    }

    @Override
    public StationDto updateStation(Long stationId, StationDto updatedStation) {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new ResourceNotFoundException("Station is not exists with given id : " + stationId));

        station.setStationName(updatedStation.getStationName());
        station.setLocation(updatedStation.getLocation());
        station.setContactInfo(updatedStation.getContactInfo());



        Station updatedStationObj = stationRepository.save(station);

        return StationMapper.mapToStationDto(updatedStationObj);
    }

    @Override
    public void deleteStation(Long stationId) {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new ResourceNotFoundException("Station is not exists with given id : " + stationId));

        stationRepository.deleteById(stationId);
    }
}
