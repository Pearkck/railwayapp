package com.kotchakorn.railwayapp.repository;

import com.kotchakorn.railwayapp.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
