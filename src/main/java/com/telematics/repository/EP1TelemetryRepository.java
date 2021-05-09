package com.telematics.repository;

import com.telematics.model.EP1Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EP1TelemetryRepository extends JpaRepository<EP1Telemetry, Long> {

}
