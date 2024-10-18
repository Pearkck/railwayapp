package com.kotchakorn.railwayapp.repository;

import com.kotchakorn.railwayapp.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
}
