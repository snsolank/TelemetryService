package com.telematics.service;

import com.telematics.controller.EP1.request.EP1TelematicsRequest;
import com.telematics.controller.EP1.request.EP1TelemetryData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EP1TelemetryService {

    void publishTelemetryData(EP1TelematicsRequest ep1TelematicsRequest);
    List<EP1TelemetryData> retrieveTelemetryData();
}
