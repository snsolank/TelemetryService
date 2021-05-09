package com.telematics.service;

import com.telematics.controller.EP1.request.EP1TelematicsRequest;
import com.telematics.model.EP1Telemetry;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EP1TelemetryService {

    void publishTelemetryData(EP1TelematicsRequest ep1TelematicsRequest);
    List<EP1TelematicsRequest> consumeTelemetryData(EP1TelematicsRequest ep1TelematicsRequest);
    List<EP1Telemetry> retrieveTelemetryData();
}
