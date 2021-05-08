package com.telematics.service;

import com.telematics.controller.EP1.request.EP1TelematicsRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EP1TelemetryService {

    List<EP1TelematicsRequest> consumeTelemetryData(EP1TelematicsRequest ep1TelematicsRequest);
}
