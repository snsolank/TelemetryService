package com.telematics.controller.EP1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EP1TelematicsRequest {
    List<EP1TelemetryData> ep1TelemetryData;
}
