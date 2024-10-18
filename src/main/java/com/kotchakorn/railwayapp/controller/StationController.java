package com.kotchakorn.railwayapp.controller;

import com.kotchakorn.railwayapp.dto.StationDto;
import com.kotchakorn.railwayapp.service.StationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/trains/stations")
public class StationController {
    private StationService stationService;

    @PostMapping
    public ResponseEntity<StationDto> createStation(@RequestBody StationDto stationDto){
        StationDto savedStation = stationService.createStation(stationDto);
        return new ResponseEntity<>(savedStation, HttpStatus.CREATED);
    }

    @GetMapping("{stationId}")
    public ResponseEntity<StationDto> getStationById(@PathVariable("stationId") Long stationId){
        StationDto stationDto = stationService.getStationById(stationId);
        return ResponseEntity.ok(stationDto);
    }

    @GetMapping
    public ResponseEntity<List<StationDto>> getAllStations(){
        List<StationDto> stations = stationService.getAllStations();
        return ResponseEntity.ok(stations);
    }

    @PutMapping("{stationId}")
    public ResponseEntity<StationDto> updateStation(@PathVariable("stationId") Long stationId,
                                                  @RequestBody StationDto updatedStation){
        StationDto stationDto = stationService.updateStation(stationId, updatedStation);
        return ResponseEntity.ok(stationDto);
    }

    @DeleteMapping("{stationId}")
    public ResponseEntity<String> deleteStation(@PathVariable("stationId") Long stationId){
        stationService.deleteStation(stationId);
        return ResponseEntity.ok("Station deleted successfully!");
    }
}
